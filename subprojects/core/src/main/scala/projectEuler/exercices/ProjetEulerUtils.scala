package projectEuler.exercices

import exercices.exercice_nombres_premiers.NombresPremiers.isPrime

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.ForkJoinTaskSupport
import scala.util.Try

object ProjetEulerUtils {


  def main(args: Array[String]): Unit = {

    println(isPrime(BigInt.apply(97)))

    println(isPrime(97.0))

    println(isPrime("97"))

    try_assert(isPrime(97), "97 is prime !  Function 'isPrime' not working !!!!")

    try_assert(!isPrime(102), "102 is not prime !  Function 'isPrime' not working !!!!")


    try_assert_seq(DoubleSeq(Seq("a", "b", "c")), Seq("a", "b", "c", "a", "b", "c"), "Coucou")

    try_assert_seq(DoubleSeq(Seq("a", "b", "c")), Seq("c", "a", "b", "c", "a", "b"), "Coucou2")


  }


  def DoubleSeq(a: Seq[String]): Seq[String] = {
    a ++ a
  }


  def try_assert_seq(
                      seq1: Seq[String],
                      seq2: Seq[String],
                      message: String
                    ): Unit = {
    try {
      assert(seq1.sorted == seq2.sorted, message)
    } catch {
      case e: Throwable => e.printStackTrace()
    }
  }

  def try_assert(
                  bool: Boolean,
                  message: String
                ): Unit = {
    try {
      assert(bool, message)
    } catch {
      case e: Throwable => e.printStackTrace()
    }
  }


  def while_batch[A](
                      subtask_computation: (Int) => Seq[A],
                      while_condition_function: (Int) => Boolean,
                      handling_function: (A) => Unit,
                      start_supp_condition_function: (Seq[A]) => Unit = (a: Seq[A]) => {},
                      end_supp_condition_function: (Seq[A]) => Unit = (a: Seq[A]) => {},
                    ): Unit = {

    var index = 0
    do {
      val subTask = subtask_computation(index)

      start_supp_condition_function(subTask)

      val par_seq = subTask.par

      par_seq.tasksupport = {
        new ForkJoinTaskSupport(
          new java.util.concurrent.ForkJoinPool(8)
        )
      }

      par_seq
        .foreach { nth =>
          handling_function(nth)
        }

      end_supp_condition_function(subTask)

      index += 1

    } while (while_condition_function(index))
  }


  def isPrime(n0: String): Boolean = {
    val n = n0.toInt
    isPrime(n)
  }

  def isPrime(n0: BigInt): Boolean = {
    val n = n0.toInt
    isPrime(n)
  }

  def isPrime(n0: Double): Boolean = {
    val n = n0.toInt
    isPrime(n)
  }

  def isPrime(n: Int): Boolean = {
    if (n == 1) return false
    val i = 2 to Math.sqrt(n).toInt
    i.find { k => n % k == 0 && k != n } match {
      case Some(_) => false
      case None => true
    }
  }


  //  def isPrime(num: BigInt): Boolean = {
  //    @tailrec
  //    def isPrime0(n: Int): Boolean = n match {
  //      case 1 => true
  //      case _ => if (num % n == 0) false else isPrime0(n - 1)
  //    }
  //
  //    if (num % 2 == 0 || num < 1)
  //      false
  //    else
  //      isPrime0(Math.sqrt(num.toInt).toInt)
  //  }

  val primeNumberBuffer: mutable.SortedSet[Int] = {
    mutable.SortedSet[Int](2)
  }

  def isOptimizedPrime(n: Int): Boolean = {

    val s = primeNumberBuffer.max + 1 to Math.sqrt(n).toInt
    val i = primeNumberBuffer ++ s

    s.foreach { k =>
      if (isPrime(k)) {
        primeNumberBuffer.add(k)
      }
    }
    i.find { k => n % k == 0 && k != n } match {
      case Some(_) => false
      case None => true
    }
  }

  def factorial(n: BigInt): BigInt = {
    if (n == 0) 1
    else {
      if (n < 3) n
      else n * factorial(n - 1)
    }
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

  def compositePrimeFactors(n: Int): ArrayBuffer[Int] = {
    val seqPrimeFactors = ArrayBuffer.empty[Int]
    var factor = 2
    var res = n
    while (res % factor == 0) {
      seqPrimeFactors.append(2)
      res /= 2
    }
    factor = 3
    while (res > 1) {
      while (res % factor == 0) {
        seqPrimeFactors.append(factor)
        res /= factor
      }
      factor += 2
    }
    seqPrimeFactors
  }
}
