package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.while_batch

import java.util.Date
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.{ForkJoinTaskSupport, defaultTaskSupport}

object Problem14_step6 {
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
    - Sixth step :
    Traverse all the triangle numbers from 1 to one million, and calculate the length of each chain produced by iterative rules :
                                n → n/2 (n is even)
                                n → 3n + 1 (n is odd)
    Transfer to the structure of while_batch
                   Time used : 421
     */
    val startTime = new Date().getTime

    var counter: Int = 1
    var max = 1
    val batch_size = 200000
    var result = 0
    while_batch(
      subtask_computation = {
        (index: Int) =>
          index * batch_size + 1 to (index + 1) * batch_size
      },
      while_condition_function = {
        (index: Int) =>
          if (counter < 1000000) true
          else
            false
      },
      handling_function = {
        (counter: Int) =>
          val length = produceChain(counter)
          max.synchronized {
            if (length > max) {
              max = length
              result = counter
            }
          }
      },
      end_supp_condition_function = {
        (subTask: Seq[Int]) =>
          counter = subTask.max + 1
      }
    )
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
