package projectEuler.exercices

import java.util.Date
import scala.collection.mutable.ArrayBuffer

object Problem23 {
  /*
    Problem 23 : Non-abundant sums
    Description :
        A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
        A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
        As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
        Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
  */
  def main(args: Array[String]): Unit = {
//    To be improved
    val startTime = new Date().getTime

    var seqAbundantNbs = Seq.empty[Int]
    val addAbundantNbs = ArrayBuffer.empty[Int]
    seqAbundantNbs = findAbundantNum
//    println(seqAbundantNbs)

    for(i<- 25 to 28123) {
      for(j<- seqAbundantNbs.indices){
        val add = i-seqAbundantNbs(j)
        if(add<seqAbundantNbs.last&&add>11&&isAbundantNum(add)&&(!addAbundantNbs.contains(i))){
          println(s"find one pair :(${seqAbundantNbs(j)},${add})")
          addAbundantNbs.append(i)
        }
      }
    }
    println("result = "+((1 to 28123).sum - addAbundantNbs.sum - 24))

    val endTime = new Date().getTime
    println(s"Time used = ${endTime-startTime}")
  }
  def findAbundantNum: Seq[Int] = {
    (12 to 28111).filter(i => sumOfDivisors(i) > i)
  }
  def isAbundantNum(i: Int):Boolean={
    sumOfDivisors(i)>i
  }
  def sumOfDivisors(n: Int): Int = {
    var seqDivisors = Seq(1)
    (2 to Math.sqrt(n).toInt).foreach(i =>
      if (n % i == 0) {
        if (n == i * i) seqDivisors = seqDivisors :+ i
        else seqDivisors = seqDivisors :+ i :+ n / i
      }
    )
    seqDivisors.sum
  }

}
