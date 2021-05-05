package projectEuler.exercices

import java.util.Date
import scala.collection.mutable
import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object Problem33 {

  /*
    Problem 33 : Digit cancelling fractions
    Description :
        The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
        We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
        There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
        If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

        Result = 100
        Time used  = 311
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    var num = 1
    var denom = 1
    (11 to 99).foreach {
      numerator =>
        (11 to 99).foreach {
          denominator =>
            val originalFraction = BigDecimal(numerator) / denominator
            val arr = new mutable.ListBuffer[(BigDecimal, Int)]
            if (originalFraction < 1) {
              var fraction1 = BigDecimal(0)
              var fraction2 = BigDecimal(0)
              var fraction3 = BigDecimal(0)
              var fraction4 = BigDecimal(0)
              if (denominator / 10 != 0 && denominator % 10 != 0) {
                if (numerator % 10 == denominator % 10)
                  fraction1 = BigDecimal(numerator / 10) / (denominator / 10)
                if (numerator / 10 == denominator % 10)
                  fraction2 = BigDecimal(numerator % 10) / (denominator / 10)
              }
              if (denominator % 10 != 0) {
                if (numerator / 10 == denominator / 10)
                  fraction3 = BigDecimal(numerator % 10) / (denominator % 10)
                if (numerator % 10 == denominator / 10)
                  fraction4 = BigDecimal(numerator / 10) / (denominator % 10)
              }
              if (fraction1 == originalFraction) arr.append((fraction1, 1))
              if (fraction2 == originalFraction) arr.append((fraction2, 2))
              if (fraction3 == originalFraction) arr.append((fraction3, 3))
              if (fraction4 == originalFraction) arr.append((fraction4, 4))
            }
            if (arr.length == 1) {
              //              println(numerator + "/" + denominator + " now arr =" + arr.last)
              num *= numerator
              denom *= denominator
            }
        }
    }
    val simple = gcd(num, denom)
    println("result = " + denom / simple)
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }

  @tailrec
  def gcd(n: Int, d: Int): Int = {
    if (d == 0) n else gcd(d, n % d)
  }
}
