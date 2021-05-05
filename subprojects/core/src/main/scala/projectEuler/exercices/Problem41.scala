package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.isPrime

import java.util.Date
import scala.collection.mutable

object Problem41 {
  /*
      Problem 41 : Pandigital prime
      Description :
          We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
          What is the largest n-digit pandigital prime that exists?

          result= 7652413
          time used  = 545

    */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    var max = 2
    val str = new StringBuilder()
    str.append(1)
    (2 to 9).foreach{n=>
      str.append(n).toString.permutations.foreach{
        elm =>
          if (isPrime(elm.toInt))
            if (elm.toInt>2) max = elm.toInt
      }
    }
    println(s"result= ${max}")

    val endTime = new Date().getTime
    println("time used  = "+(endTime - startTime))
  }


}
