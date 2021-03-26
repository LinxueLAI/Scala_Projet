package projectEuler.exercices


import java.util.Date
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.ForkJoinTaskSupport

object Problem12_step4_parallel {
  /*
   Problem 12 : Highly divisible triangular number
   Description :
       We can see that 28 is the first triangle number to have over five divisors.
       What is the value of the first triangle number to have over five hundred divisors?
  */
  def main(args: Array[String]): Unit = {
    /*
      - Forth step :
        -> modify the second version of code to a parallel structure

        result : 76576500
        time used = 951

   */

    val startTime= new Date().getTime

    val batchSize = 1000
    var index = 0
    val seqNbOfFactors= new ArrayBuffer[(Int,Int)]
    do{
      seqNbOfFactors.clear()
      val subTask = (index*batchSize+1 to (index+1)*batchSize)

      val par_seq = subTask
        .par

      par_seq.tasksupport = {
        new ForkJoinTaskSupport(
          new java.util.concurrent.ForkJoinPool(4)
        )
      }
      par_seq
        .foreach{nth=>
          val triNumber = nth*(nth+1)/2
          val seq = compositePrimeFactors(triNumber)
          val nbOfFactors = (1 to seq.size).flatMap(seq.combinations).map(_.product).distinct.size
          if(nbOfFactors>500) {
            seqNbOfFactors.synchronized{
              seqNbOfFactors.append((triNumber,nbOfFactors))
            }
          }
        }
      index+=1
    }while(seqNbOfFactors.isEmpty || seqNbOfFactors.map(_._2).min<=500)

    println(s"result : ${seqNbOfFactors.map(_._1).min}")

    val endTime= new Date().getTime
    println(s"time used = ${endTime - startTime}")
  }
  def compositePrimeFactors(n:Int):ArrayBuffer[Int] = {
    var seqPrimeFactors = ArrayBuffer(1)
    var factor = 2
    var res = n
    while(res%factor==0) {
      seqPrimeFactors.append(2)
      res /= 2
    }
    factor = 3
    while (res>1){
      while (res%factor==0){
        seqPrimeFactors.append(factor)
        res /= factor
      }
      factor+=2
    }
    seqPrimeFactors
  }
}
