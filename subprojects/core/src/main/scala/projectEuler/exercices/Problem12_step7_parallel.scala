package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.{compositePrimeFactors, isPrime}

import java.util.Date
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Problem12_step7_parallel {
  /*
   Problem 12 : Highly divisible triangular number
   Description :
       We can see that 28 is the first triangle number to have over five divisors.
       What is the value of the first triangle number to have over five hundred divisors?
  */
  val primeNumberBuffer: ArrayBuffer[Int] = ArrayBuffer(2)


  def main(args: Array[String]): Unit = {
    /*
    - Seventh step :
      -> modify the third version of code to a parallel structure

      Result : 76576500
      Time used = 791
    */
    val startTime = new Date().getTime

    val batch_size = 2000
    val result = new mutable.ListBuffer[(Int, Int)]
    ProjetEulerUtils
      .while_batch(

        subtask_computation = {
          (index: Int) =>
            result.clear()
            index * batch_size + 1 to (index + 1) * batch_size
        },

        while_condition_function = {
          (index: Int) =>
            result.forall(elm => elm._2 < 500)
        },

        start_supp_condition_function = {
          (subTask: Seq[Int]) =>
            val maxNth = subTask.max
            val maxTriNumber = (maxNth + 1) * maxNth / 2
            //      save all the prime numbers which are smaller than maxTriNumber
            val primeNumbers = (primeNumberBuffer.max to Math.sqrt(maxTriNumber).toInt)
              .par
              .filter { i => isPrime(i) }
            primeNumberBuffer.append(primeNumbers.toList.sorted: _*) // insert each element of primeNumbers to primeNumberBuffer
        },

        handling_function = {
          (nth: Int) =>
            val triNumber = nth * (nth + 1) / 2
            val seq = compositePrimeFactors(triNumber)
            val nbOfFactors = (1 to seq.size).flatMap(seq.combinations).map(_.product).distinct.size
            if (nbOfFactors > 500) {
              result.synchronized {
                result.append((triNumber, nbOfFactors))
              }
            }
        }
      )
    //add new function : start_supp_condition_function

    println(s"Result : ${result.map(elm => elm._1).min}")

    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")
  }

  def findPrimeFactor(i: Int): Seq[Int] = {
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
