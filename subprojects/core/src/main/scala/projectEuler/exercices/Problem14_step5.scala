package projectEuler.exercices

import java.util.Date
import scala.collection.parallel.ForkJoinTaskSupport

object Problem14_step5 {
  /*
      Problem 14 :  Longest Collatz sequence
      Description :
          The following iterative sequence is defined for the set of positive integers:
                            n → n/2 (n is even)
                            n → 3n + 1 (n is odd)
          Using the rule above and starting with 13, we generate the following sequence:
                            13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
          It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem),
      it is thought that all starting numbers finish at 1.
          Which starting number, under one million, produces the longest chain?
          NOTE: Once the chain starts the terms are allowed to go above one million.
    */
  def main(args: Array[String]): Unit = {
    /*
    - Fifth step :
    Traverse all the triangle numbers from 1 to one million, and calculate the length of each chain produced by iterative rules :
                                n → n/2 (n is even)
                                n → 3n + 1 (n is odd)
    Delete the use of do while and ddd the use of parallelism. Simplified the algo by using the function map.

    Advantage : algorithm is simplified and the code is the easiest to be read, but the use of map may bring problem of RAM when the numbers which need to be calculated is large(the use of map calculate and save the elements)
                   Time used : 505
    */
    val startTime = new Date().getTime

    val indices = (0 to 1000000).par

    val results = indices.map { counter =>
      val length = produceChain(counter)
      (counter, length)
    }

    val (max_result, _) = results.maxBy { case (_, length) => length }

    println(s"result = ${max_result}")
    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")
  }

  def produceChain(n: Int): Int = {
    var count = 1
    var tmp: Long = n.toLong
    while (tmp > 1) {
      if (tmp % 2 == 0)
        tmp = tmp / 2
      else
        tmp = tmp * 3 + 1
      count += 1
    }
    count
  }
}
