package projectEuler.exercices

import java.util.Date
import scala.collection.immutable.StreamView

object Problem02_solution2 {
  /*
     Problem 2 : Even Fibonacci numbers
     Description :
        Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
        By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
   */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    //    second solution:
    lazy val fs: Stream[Int] = 1 #:: fs.scanLeft(2)(_ + _)
    val r: StreamView[Int, Stream[Int]] = fs
      .view
      .takeWhile(_ <= 4000000)
      .filter(_ % 2 == 0) // takeWhile : it returns the elements from the list as long as the stated condition is satisfied.
    println(r.sum)
    val endTime = new Date().getTime
    println(s"time used : ${endTime - startTime}")
  }
}
