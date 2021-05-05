package projectEuler.exercices

import java.util.Date

object Problem26 {
  /*
    Problem 26 : Reciprocal cycles
    Description :
        Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
        Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

        result = 983
        time used  = 2405

  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    var num = 7
    var max = 0
    val a = BigDecimal(1)
    var res = 0
    while (num < 1000) {
      val d = BigDecimal(num)
      val result = {
        a
          .bigDecimal
          .divide(
            d.bigDecimal,
            2000,
            java.math.RoundingMode.DOWN
          )
      }
      val str = result.toString.init.split("\\.").last
      var prefix = ""
      var flag = 0
      val n = str.length
      for (i <- 0 until n; j <- i + 6 to n / 2) {
        if (flag == 0) {
          prefix = str.substring(i, j)
          if (str.substring(j).startsWith(prefix)) {
            flag = 1
            if (max < prefix.length) {
              max = prefix.length
              res = num
            }
          }
        }
      }
      num += 1
    }
    println(s"result = ${res}")
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }

}
