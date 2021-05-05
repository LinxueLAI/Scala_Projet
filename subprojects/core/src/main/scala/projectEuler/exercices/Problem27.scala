package projectEuler.exercices

import java.util.Date
import scala.annotation.tailrec


object Problem27 {
  /*
    Problem 27 : Quadratic primes
    Description :
        Find the product of the coefficients,a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.

        result : (-61,971,62), product -> -59231
        time used  = 132


  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    val result = Range(-1000, 1000).filter(isPrime).map(getMaxConsecutivePrime).maxBy(_._3)
    println(s"result : ${result}, product -> ${result._1 * result._2}")

    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }

  val primeSet: Set[Int] = Range(1, 1000).filter(isPrime).toSet

  def listConsecutivePrimes(a: Int, b: Int, n: Int = 0): List[Int] = {
    val res = n * n + a * n + b
    if (primeSet.contains(res))
      res :: listConsecutivePrimes(a, b, n + 1)
    else Nil
  }

  def getMaxConsecutivePrime(b: Int): (Int, Int, Int) = {
    Range(-1000, 1000).map((_, b)).map(
      {
        case (x, y) => (x, y, listConsecutivePrimes(x, y).length)
      }
    ).maxBy(_._3)

  }

  def isPrime(num: Int): Boolean = {
    @tailrec
    def isPrime0(n: Int): Boolean = n match {
      case 1 => true
      case _ => if (num % n == 0) false else isPrime0(n - 1)
    }

    if (num % 2 == 0 || num < 1)
      false
    else
      isPrime0(Math.sqrt(num).toInt)
  }
}
