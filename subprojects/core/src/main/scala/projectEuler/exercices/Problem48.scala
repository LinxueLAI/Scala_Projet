package projectEuler.exercices

import java.util.Date

object Problem48 {
  /*
  Problem 48  : Self powers
  Description :
    The series, 1**1 + 2**2 + 3**3 + ... + 10**10 = 10405071317.
    Find the last ten digits of the series, 1**1 + 2**2 + 3**3 + ... + 1000**1000.

  result = 9110846700
  time used  = 380
  */

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    val str = (1 to 1000).map {
      elm =>
        bigPower(elm, elm)
    }.sum
    println(str.toString.splitAt(str.toString.length - 10)._2)
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }

  def bigPower(i: Int, n: Int): BigInt = {
    if (n == 1) i
    else i * bigPower(i, n - 1)
  }
}
