package projectEuler.exercices

import java.util.Date
import scala.collection.mutable.ArrayBuffer

object Problem36 {
  /*
    Problem 36 : Double-base palindromes
    Description :
        The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
        Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
        (Please note that the palindromic number, in either base, may not include leading zeros.)
        Result = 872187
        Time used  = 460

  */


  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    val result = (1 to 1000000).filter { elm =>
      elm.toString == elm.toString.reverse && base10to2(elm).reverse == base10to2(elm)
    }.sum

    println(result)
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }

  def base10to2(n: Int): String = {
    var res = n
    var str = ""
    while (res != 0) {
      val tmp: Int = res % 2
      str = str.concat(tmp.toString)
      res = res / 2
    }
    str.reverse
  }
}
