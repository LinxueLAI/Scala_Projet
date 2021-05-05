package projectEuler.exercices

import java.util.Date

object Problem03 {
  /*
    Problem 3 :  Largest prime factor
    Description :
        The prime factors of 13195 are 5, 7, 13 and 29.
        What is the largest prime factor of the number 600851475143 ?

        result = 6857
        result = 6857
        time used : 0
  */
  def main(args: Array[String]): Unit = {
    //    first solution:
    val startTime = new Date().getTime
    println(s"result = ${maxPrimeFactor(600851475143L)}")

    val endTime = new Date().getTime
    println(s"time used : ${endTime - startTime}")
  }

  def maxPrimeFactor(n: Long): Long = {
    var factor = 2
    var res = n
    var lastFactor = 1
    while (res > 1) {
      if (res % factor == 0) {
        lastFactor = factor
        res /= factor
        while (res % factor == 0)
          res /= factor
      }
      factor += 1
    }
    lastFactor
  }

  //    second solution:
  def factors(n: Long): List[Long] =
    (2 to math.sqrt(n).toInt)
      .find(n % _ == 0)
      .fold(List(n))(
        i =>
          i.toLong :: factors(n / i)
      )

  println(s"result = ${factors(600851475143L).max}")
}
