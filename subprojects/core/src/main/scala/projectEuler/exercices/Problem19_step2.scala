package projectEuler.exercices

import java.time.LocalDate
import java.util.Date

object Problem19_step2 {
  def main(args: Array[String]): Unit = {
    /*
      Problem 19 : Counting Sundays
      Description :
          You are given the following information, but you may prefer to do some research for yourself.

          1 Jan 1900 was a Monday.
          Thirty days has September,
          April, June and November.
            All the rest have thirty-one,
          Saving February alone,
          Which has twenty-eight, rain or shine.
            And on leap years, twenty-nine.
            A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

          How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

          solution 2 :  the use of API JAVA simplified the code
          count = 171
          Time used = 262
     */

    val startTime = new Date().getTime
    var count = 0
    (1901 to 2000).foreach {
      year =>
        (1 to 9).foreach { month =>
          val tmp = year.toString + "-0" + month.toString + "-01"
          val dateWeek = LocalDate.parse(tmp)
          if (dateWeek.getDayOfWeek.toString == "SUNDAY") count += 1
        }
        (10 to 12).foreach { month =>
          val tmp1 = year.toString + "-" + month.toString + "-01"
          val dateWeek1 = LocalDate.parse(tmp1)
          if (dateWeek1.getDayOfWeek.toString == "SUNDAY") count += 1
        }
    }
    println(s"count = ${count}")
    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")

  }

}
