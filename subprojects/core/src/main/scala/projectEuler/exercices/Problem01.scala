package projectEuler.exercices

import java.util.Date

object Problem01 {
  /*
     Problem 1 : Multiples of 3 and 5
     Description :
        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
        Find the sum of all the multiples of 3 or 5 below 1000.

        sum = 233168
        Time used : 229
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    println(s"sum = ${
      (3 until 1000)
        .view
        .filter(
          p =>
            p % 5 == 0 || p % 3 == 0
        )
        .sum
    }")

    val endTime = new Date().getTime
    println(s"time used : ${endTime - startTime}")
  }
}
