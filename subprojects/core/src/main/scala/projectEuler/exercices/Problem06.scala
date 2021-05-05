package projectEuler.exercices

import java.util.Date

object Problem06 {
  /*
    Problem 6 :  Sum square difference
    Description :
        Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

        Difference = 25164150
        Time used = 233

  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    var sum1, sum2 = 0
    for (i <- 1 to 100 by 1) {
      sum1 += i * i
      sum2 += i
    }
    println("difference = " + (sum2 * sum2 - sum1))

    val endTime = new Date().getTime
    println(s"time used = ${endTime - startTime}")
  }

}
