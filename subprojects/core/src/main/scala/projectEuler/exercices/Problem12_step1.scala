package projectEuler.exercices

import java.util.Date

object Problem12_step1 {
  /*
    Problem 12 : Highly divisible triangular number
    Description :
        We can see that 28 is the first triangle number to have over five divisors.
        What is the value of the first triangle number to have over five hundred divisors?
  */
  def main(args: Array[String]): Unit = {
    /*
      - First step :
      The nth triangle number  = (n+1)*n/2
      Try to traverse all the triangle numbers from 1 to n, and calculate the factors of each triangle number

      Advantage : algorithm is simple and code is easy to understand

      Disadvantage : high time complexity :1553720 ms = 1554s = plus de 20min
     */

    val startTime = new Date().getTime

    var nth = 1
    var result = 0
    var triNumber = 2
    do {
      triNumber = nth * (nth + 1) / 2
      result = numbersOfFactors(triNumber)
      nth += 1
    } while (result < 500)

    println(s"result = ${triNumber}")
    val endTime = new Date().getTime
    println(s"time used : ${startTime - endTime}")
  }

  def numbersOfFactors(n: Int): Int = {
    (1 to n).count(n % _ == 0)
  }
}
