package projectEuler.exercices

import java.util.Date
import scala.collection.mutable.ArrayBuffer
import projectEuler.exercices.ProjetEulerUtils.factorial

object Problem34 {
  /*
    Problem 34 : Digit factorials
    Description :
        145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
        Find the sum of all numbers which are equal to the sum of the factorial of their digits.
        Note: As 1! = 1 and 2! = 2 are not sums they are not included.

        result = 40730
        time used  = 560
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    val list = ArrayBuffer(0, 1, 2)
    (3 to 50000).foreach { n =>
      val s = n.toString.map(elm => factorial(elm.asDigit)).sum
      if (s == n) {
        list.append(n)
      }
    }
    //    println(s"there are ${list.length - 3} satisfy the conditions :${(3 until  list.length).foreach(elm =>println(list(elm)))}; result = ${list.sum -3}")
    println(s"result = ${list.sum - 3}")
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }
}
