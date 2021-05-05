package projectEuler.exercices

import java.util.Date

object Problem43 {
  /*
    Problem 43 : Sub-string divisibility
    Description :
      The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
      Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
          d2d3d4=406 is divisible by 2
          d3d4d5=063 is divisible by 3
          d4d5d6=635 is divisible by 5
          d5d6d7=357 is divisible by 7
          d6d7d8=572 is divisible by 11
          d7d8d9=728 is divisible by 13
          d8d9d10=289 is divisible by 17
      Find the sum of all 0 to 9 pandigital numbers with this property.

      Result = 16695334890
      Time used  = 1691

  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    var counter: Long = 0L
    "0123456789".permutations.foreach {
      elm =>
        if (elm != "0123456789") {
          val str1 = elm.substring(1, 4)
          val str2 = elm.substring(2, 5)
          val str3 = elm.substring(3, 6)
          val str4 = elm.substring(4, 7)
          val str5 = elm.substring(5, 8)
          val str6 = elm.substring(6, 9)
          val str7 = elm.substring(7, 10)
          if (str1.toInt % 2 == 0 && str2.toInt % 3 == 0 && str3.toInt % 5 == 0 && str4.toInt % 7 == 0 && str5.toInt % 11 == 0 && str6.toInt % 13 == 0 && str7.toInt % 17 == 0) {
            counter = counter + elm.toLong
          }
        }
    }
    println(counter)
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }

}
