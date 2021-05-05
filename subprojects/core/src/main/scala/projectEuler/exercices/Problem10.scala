package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.isPrime

import java.util.Date

object Problem10 {
  /*
    Problem 10 : Summation of primes
    Description :
        The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
        Find the sum of all the primes below two million.

        142913828922
        time used = 16058
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    println(2+(3 to 2000000 by 2).filter(isPrime).map(_.toLong).sum)
    val endTime = new Date().getTime
    println(s"time used = ${endTime - startTime}")
  }

}
