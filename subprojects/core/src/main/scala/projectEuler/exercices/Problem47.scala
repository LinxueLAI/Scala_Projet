package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.compositePrimeFactors

import java.util.Date
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.ForkJoinTaskSupport

object Problem47 {

  /*
  Problem 47  : Distinct primes factors
  Description :
      The first two consecutive numbers to have two distinct prime factors are:
      14 = 2 × 7
      15 = 3 × 5
      The first three consecutive numbers to have three distinct prime factors are:
      644 = 2² × 7 × 23
      645 = 3 × 5 × 43
      646 = 2 × 17 × 19.
      Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

    result = 134043
    time used  = 1119   (with parallelism)
  */


  def main(args: Array[String]): Unit = {

    (0 to 10).forall {
      e =>
        e < 5
    }
    val startTime = new Date().getTime
    val result = ArrayBuffer.empty[Int]
    val batch_size = 2000
    ProjetEulerUtils.while_batch(
      subtask_computation = {
        (index: Int) =>
          index * batch_size + 1 to (index + 1) * batch_size
      },
      while_condition_function = {
        (index: Int) =>
          result.isEmpty
      },
      handling_function = {
        (elm: Int) =>
          if (
            (0 to 3).forall { number: Int =>
              compositePrimeFactors(elm + number).distinct.length == 4
            }
          ) {
            result.synchronized {
              result.append(elm)
            }
          }
      }
    )
    println(s"result = ${result.min}")
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }

  def forall[A](
                 array: Array[A],
                 predicat: A => Boolean
               ): Boolean = {
    var res = true
    var i = -1

    def next() = {
      array(i)
    }

    def hasNext() = {
      i += 1
      i < array.length
    }

    while (res && hasNext()) res = predicat(next())
    res
  }
}
