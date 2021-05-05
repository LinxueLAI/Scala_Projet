package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.isPrime

import java.util.Date
import scala.collection.mutable.ArrayBuffer

object Problem35 {
  /*
    Problem 35 : Circular primes
    Description :
        The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
        There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
        How many circular primes are there below one million?

    Result = 55
    Time used  = 1922
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    val arr = ArrayBuffer(2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97).length
    println("result = " + ((101 to 1000000).count(isCircularPrimes) + arr))
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }

  def isCircularPrimes(n: Int): Boolean = {
    var lenSeq = 0
    if (isPrime(n)) lenSeq += 1 else return false
    val seqCircularPrimes = ArrayBuffer(n)
    val length = n.toString.map(_.asDigit).length
    var res = n
    var newN = n
    (1 until length).foreach { _ =>
      res = newN % 10
      newN = newN / 10 + res * math.pow(10, length - 1).toInt
      seqCircularPrimes.append(newN)
    }
    if (n.toString.map(_.asDigit).length != seqCircularPrimes.length) false
    else {
      seqCircularPrimes.indices.forall(elm => isPrime(seqCircularPrimes(elm)))
    }
  }
}
