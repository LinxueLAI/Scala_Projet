package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.{isOptimizedPrime, isPrime}

import java.util.Date

object Problem10_step2 {
  /*
    Problem 10 : Summation of primes
    Description :
        The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
        Find the sum of all the primes below two million.

      Add the use of parallelization
        result : 142913828922
        time used = 3959
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    println(
      2 +
        (3 to 2000000 by 2)
          .par
          .filter(isOptimizedPrime)
          .map(_.toLong)
          .sum
    )
    val endTime = new Date().getTime
    println(s"time used = ${endTime - startTime}")
  }

}
