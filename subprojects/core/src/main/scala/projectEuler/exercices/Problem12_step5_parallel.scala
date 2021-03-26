package projectEuler.exercices

import java.util.Date
import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.ForkJoinTaskSupport

object Problem12_step5_parallel {
  /*
   Problem 12 : Highly divisible triangular number
   Description :
       We can see that 28 is the first triangle number to have over five divisors.
       What is the value of the first triangle number to have over five hundred divisors?
  */
  val primeNumberBuffer: ArrayBuffer[Int] = ArrayBuffer(2)

  def main(args: Array[String]): Unit = {
    /*
    - Fifth step :
      -> modify the third version of code to a parallel structure

      Result : 76576500
      Time used = 791
    */
    val startTime = new Date().getTime

    var index = 0
    val batch_size = 2000
    val result= new mutable.ListBuffer[(Int, Int)]
    do{
      result.clear()

      val subTask = index*batch_size+1 to (index+1)*batch_size

      val maxNth = subTask.max
      val maxTriNumber = (maxNth + 1) * maxNth / 2

//      save all the prime numbers which are smaller than maxTriNumber
      val primeNumbers = (primeNumberBuffer.max to Math.sqrt(maxTriNumber).toInt)
        .par
        .filter{i=> isPrime(i) }

      val par_seq = subTask
        .par

      par_seq.tasksupport = {
        new ForkJoinTaskSupport(
          new java.util.concurrent.ForkJoinPool(8)
        )
      }

      primeNumberBuffer.append(primeNumbers.toList.sorted:_*)// insert each element of primeNumbers to primeNumberBuffer

//      println(s"prime numbers Sequence  = ${primeNumbers}")
      par_seq
        .foreach{ nth =>
          val triNumber = (nth + 1) * nth / 2
          // println(s"triNumber = ${triNumber}")
          val seq1 = findPrimeFactor(triNumber)
          //println(s"primNum = ${primeNumberBuffer}")
          val a = (1 to seq1.length).flatMap(seq1.combinations).map(_.product).distinct.size
          if(a>=500){
            println(s"a = $a")
            result.synchronized{
              result.append((triNumber,a))
            }
          }
        }
      index+=1
    }while(result.forall(elm =>elm._2<500))

    println(s"Result : ${result.map(elm=> elm._1).min}")

    val endTime = new Date().getTime
    println(s"Time used = ${endTime-startTime}")
  }

  def isPrime(n: Int) :Boolean={
    val i = 2 to Math.sqrt(n).toInt
    i.find{k => n%k==0 &&k!=n}match {
      case Some(_) =>false
      case None =>true
    }
  }

  def findPrimeFactor(i: Int):Seq[Int]= {
    val seqFactors = ArrayBuffer(1)
    var res = i
    primeNumberBuffer.foreach { k =>
      while (res % k == 0) {
        seqFactors.append(k)
        res /= k
      }
    }
    seqFactors
  }
}
