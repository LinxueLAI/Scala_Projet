package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.isPrime

import java.util.Date
import scala.collection.mutable.ArrayBuffer

object Problem07 {
  /*
    Problem 7 : 10001st prime
    Description :
        By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
        What is the 10 001st prime number?

        104743
        time used = 702

   */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    val seqPrime = ArrayBuffer(0)
    var n = 2
    var counter = 1

    while (counter < 10001) {
      n += 1
      if (isPrime(n)) {
        counter += 1
        seqPrime.append(n)
      }
    }
    println(seqPrime.max)

    val endTime = new Date().getTime
    println(s"time used = ${endTime - startTime}")
  }

}
