package projectEuler.exercices

import java.util.Date

object Problem04 {
  /*
    Problem 4 :  largest palindrome product
    Description :
        A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
        Find the largest palindrome made from the product of two 3-digit numbers.

        Result : 906609
        Solution 1 : time used = 288
        Solution 2 : time used = 148
  */
  def main(args: Array[String]): Unit = {
    //    first solution :
    var startTime = new Date().getTime
    println(maxPalindrome)
    var endTime = new Date().getTime
    println(s"time used = ${endTime - startTime}")

    //    second solution :
    startTime = new Date().getTime
    println(
      (100 to 999)
        .flatMap(
          i => (100 to 999)
            .map(_ * i)
            .filter(
              elm =>
                elm.toString == elm.toString.reverse
            )
        ).max
    )
    endTime = new Date().getTime
    println(s"time used = ${endTime - startTime}")

  }

  def isPalindrome(n: Long): Boolean = n.toString == n.toString.reverse

  def maxPalindrome: Int = {
    var seq = Seq(0)
    var x = 0
    for (i <- 100 to 999) {
      var j = 0
      var dis = 0
      if (i % 11 == 0) {
        j = 999
        dis = 1
      }
      else {
        j = 990
        dis = 11
      }
      while (j >= i) {
        if (isPalindrome(i * j)) {
          x = i * j
          seq = seq :+ x
        }
        j -= dis
      }
    }
    seq.max
  }

}
