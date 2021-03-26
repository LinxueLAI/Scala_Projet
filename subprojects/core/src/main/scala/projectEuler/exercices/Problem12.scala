package projectEuler.exercices

import com.typesafe.scalalogging.LazyLogging

import java.util.Date
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.parallel.ForkJoinTaskSupport
object Problem12 extends LazyLogging {
  /*
    Problem 12 : Highly divisible triangular number
    Description :
        We can see that 28 is the first triangle number to have over five divisors.
        What is the value of the first triangle number to have over five hundred divisors?
  */

  val primeNumberBuffer: ArrayBuffer[Int] = ArrayBuffer(2)

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    var index = 0
    val batch_size = 2000
    val result= new mutable.ListBuffer[(Int, Int)]
    do{
      result.clear()
      val subTask = (index*batch_size+1 to (index+1)*batch_size)
      val par_seq = subTask
        .par

      par_seq.tasksupport = {
        new ForkJoinTaskSupport(
          new java.util.concurrent.ForkJoinPool(8)
        )
      }

      val maxNth = subTask.max
      val maxTriNumber = (maxNth + 1) * maxNth / 2


      val primeNumbers = (primeNumberBuffer.max to Math.sqrt(maxTriNumber).toInt)
        .par
        .filter{i=> i%2!=0 && isPrime(i) }

      primeNumberBuffer.append(primeNumbers.toList.sorted:_*)

      par_seq
        .foreach{ nth =>
          val triNumber = (nth + 1) * nth / 2
          // println(s"triNumber = ${triNumber}")
          val seq1 = {
              findPrimeFactorV2(triNumber)
          }
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
    println(s"result : ${result.map(elm=> elm._1).min}")

    val endTime = new Date().getTime
    println(endTime-startTime)
  }

  def isPrime(n: Int) :Boolean={
    var i = 2 to Math.sqrt(n).toInt
    i.find{k => n%k==0 &&k!=n}match {
      case Some(_) =>false
      case None =>true
    }
  }

  def getFactorNumbers(n: Int):Seq[Int] = {(1 to n).filter(i=> n%i==0)}


  def findPrimeFactorV2(i: Int):Seq[Int]= {
    val seqFactors = ArrayBuffer(1)
    var res = i
    primeNumberBuffer.foreach { k =>
      var tmp: Int = k
      while (res % tmp == 0) {
        seqFactors.append(tmp)
        res /= tmp
      }
    }

    seqFactors
  }
}

