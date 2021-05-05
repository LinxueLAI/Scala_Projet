package projectEuler.exercices

import java.util.Date

object Problem30 {
  /*
    Problem 30 : Digit fifth powers
    Description :
        The sum of these numbers is 1634 + 8208 + 9474 = 19316.

        Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

        result = 443839
        time used  = 929
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    var limit = 1
    var end = 0
    var result = Seq.empty[Int]

    while (end < 7) {
      val seq = limit.toString.map(_.asDigit)
      end = seq.length

      if (seq.map(elm => math.pow(elm, 5)).sum == limit) {
        result = result :+ limit
      }
      limit += 1
    }
    println("result = " + (result.sum - 1)) // 1 = 1^5 is not a sum, so it should not be included.
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }

}
