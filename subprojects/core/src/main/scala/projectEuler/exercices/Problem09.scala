package projectEuler.exercices

import java.util.Date

object Problem09 {
  /*
  Problem 9 : Special Pythagorean triplet
  Description :
      There exists exactly one Pythagorean triplet for which a + b + c = 1000.
      Find the product abc.

      31875000
      time used = 250
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    for (i <- 1 to 1000) {
      for (j <- 1 to 1000) {
        if (isOk(i, j)) {
          //          println("i:" + i + ",j:" + j + ",k:" + (1000 - i - j))
          println(i * j * (1000 - i - j))
        }
      }
    }
    val endTime = new Date().getTime
    println(s"time used = ${endTime - startTime}")
  }

  def isOk(a: Int, b: Int): Boolean = {
    val c = 1000 - a - b
    a * a + b * b == c * c
  }

}
