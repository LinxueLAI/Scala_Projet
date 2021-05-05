package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.sumOfDivisors

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
    /*
      - Second step :
      A perfect number : the sum of its proper divisors is exactly equal to the number. ex: 1 + 2 + 4 + 7 + 14 = 28 ;
      A deficient number n :  sum of its proper divisors < n ;
      A abundant number n :  n < sum of its proper divisors.

      If a number x > 28123, it can be written as the sum of two abundant numbers.
      Q : Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

      Consider only the interval from 0 to 28123, if we can find all the positive integers that can be written as sum of two abundant numbers,
      then we can know the set which contains all the positive integers which cannot be written as the sum of two abundant numbers.(the two sets are complementary to each other)

      Result = 4179871
      Time used  = 2913
    */
    val startTime = new Date().getTime
    val seqAbNum = findAbundantNum
    val sumOfTwoAbundantNbs = seqAbNum.flatMap { abNum =>
      seqAbNum.takeWhile(_ <= (28123 - abNum)).map(_ + abNum)
    }
    println(s"result = ${(1 to 28123 diff sumOfTwoAbundantNbs).sum}")
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }

  def findAbundantNum: Seq[Int] = {
    val seqAbundantNum = ArrayBuffer.empty[Int]
    (1 to 28123).foreach { nb =>
      if (isAbundantNum(nb))
        seqAbundantNum.append(nb)
    }
    seqAbundantNum
  }

  def isAbundantNum(i: Int): Boolean = {
    sumOfDivisors(i) > i
  }

//  def sumOfDivisors(n: Int): Int = {
//    (1 to (n / 2)).filter(elm => n % elm == 0).sum
//  }
}