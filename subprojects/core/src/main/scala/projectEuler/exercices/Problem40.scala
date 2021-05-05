package projectEuler.exercices

import java.util.Date

object Problem40 {
  /*
    Problem 40 : Champernowne's constant
    Description :

        An irrational decimal fraction is created by concatenating the positive integers:

        0.123456789101112131415161718192021...

        It can be seen that the 12th digit of the fractional part is 1.

        If dn represents the nth digit of the fractional part, find the value of the following expression.

        d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
  */

  /*
  result = 210
  time used  = 266
   */

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    val str = new StringBuilder() // comparing to the str = str+ n , it doesn't need to copy the string each time.

    var n = 1
    var product = 1
    var length = 0

    while (length < 1000000) {
      str.append(n.toString)
      length = str.length
      n += 1
    }

    product = str.charAt(0).asDigit * str.charAt(9).asDigit * str.charAt(99).asDigit * str.charAt(999).asDigit * str.charAt(9999).asDigit * str.charAt(99999).asDigit * str.charAt(999999).asDigit
    println(s"result = ${product}")

    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }

}
