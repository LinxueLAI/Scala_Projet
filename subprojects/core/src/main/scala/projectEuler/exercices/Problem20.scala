package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.factorial

import java.util.Date

object Problem20 {
  /*
    Problem 20 : Factorial digit sum
    Description :
        n! means n × (n − 1) × ... × 3 × 2 × 1
        For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
        and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
        Find the sum of the digits in the number 100!

        Result = 648
        Time used = 314
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    println(factorial(100).toString().map(_.asDigit).sum)
    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")
  }

}
