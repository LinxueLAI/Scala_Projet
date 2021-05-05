package projectEuler.exercices

import java.util.Date
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.{ForkJoinTaskSupport, defaultTaskSupport}

object Problem14_step3 {
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
    - Third step :
    Traverse all the triangle numbers from 1 to one million, and calculate the length of each chain produced by iterative rules :
                                n → n/2 (n is even)
                                n → 3n + 1 (n is odd)
    Add the use of parallelism.
    Advantage : algorithm is simple and the time complexity is reduced.
                   Time used : 421
     */
    val startTime = new Date().getTime

    var counter: Int = 1
    var max = 1
    val batchSize = 200000
    var index = 0
    var result = 0
    do {
      val subTask = index * batchSize + 1 to (index + 1) * batchSize
      val par_seq = subTask
        .par

      par_seq.tasksupport = {
        new ForkJoinTaskSupport(
          new java.util.concurrent.ForkJoinPool(5)
        )
      }
      par_seq
        .foreach {
          counter =>
            val length = produceChain(counter)
            max.synchronized {
              if (length > max) {
                max = length
                result = counter
              }
            }
        }
      counter = subTask.max + 1
      index += 1
    } while (counter < 1000000)
    println(s"result = ${result}")
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
