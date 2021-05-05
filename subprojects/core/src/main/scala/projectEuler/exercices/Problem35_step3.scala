package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.isPrime

import java.util.Date
import java.util.concurrent.ForkJoinPool
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.{ForkJoinTaskSupport, ForkJoinTasks}

object Problem35_step3 {
  /*
    Problem 35 : Circular primes
    Description :


        The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
        There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
        How many circular primes are there below one million?

    result = 55
    time used  = 1205

  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime


    val arr = ArrayBuffer(2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97).length
    val subTask = (101 to 1000000 by 2).par
    subTask.tasksupport = {
      new ForkJoinTaskSupport(
        new ForkJoinPool(6)
      )
    }
    val result = subTask.count(isCircularPrimes)
    println("result = " + (result + arr))
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }

  def isCircularPrimes(n: Int): Boolean = {
    var lenSeq = 0
    if (isPrime(n)) lenSeq += 1 else return false
    val length = n.toString.map(_.asDigit).length
    val res = n.toString

    val seqCircularPrimes = {
      (0 until length).map { i =>
        (res.substring(i, res.length) + res.substring(0, i)).toInt
      }
    }

    if (n.toString.map(_.asDigit).length != seqCircularPrimes.length) {
      false
    } else {
      seqCircularPrimes.forall(elm => isPrime(elm))
    }
  }
}
