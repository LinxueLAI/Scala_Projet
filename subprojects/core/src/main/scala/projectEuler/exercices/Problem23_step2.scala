package projectEuler.exercices

import java.util.Date
import scala.collection.mutable.ArrayBuffer

object Problem23_step2 {
  /*
    Problem 23 : Non-abundant sums
    Description :
        A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
        A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
        As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
        Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    val as = findAbundantNum
    val sumOfTwoAbundantNbs = as.view.flatMap { a =>
      as.takeWhile(_ <= (28123 - a)).map(_ + a)
    }
//    println(s"nb of all the possibilities = ${(1 to 28123 diff sumOfTwoAbundantNbs).size}")
    println(s"result = ${(1 to 28123 diff sumOfTwoAbundantNbs).sum}")
    val endTime = new Date().getTime
    println("time used  = "+(endTime - startTime))

  }
  def findAbundantNum: Seq[Int] = {
    (0 to 28123).map(n => (1 to (n / 2)).filter(n % _ == 0).sum)
      .zipWithIndex.filter(p => p._1 > p._2).map(_._2)
  }
}
