package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.isPrime

import java.util.Date
import scala.collection.mutable.ArrayBuffer

object Problem46 {
  /*
  Problem 46 : Goldbach's other conjecture
  Description :

      It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
      9 = 7 + 2×1²
      15 = 7 + 2×2²
      21 = 3 + 2×3²
      25 = 7 + 2×3²
      27 = 19 + 2×2²
      33 = 31 + 2×1²
      It turns out that the conjecture was false.
      What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

      Remark : most numbers have more than two factors, and they are called composite numbers

      min = 5777
      time used  = 2885 (without parallelism)

      min = 5777
      time used  = 852 (with parallelism)

  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    var result = 0
    val compositePrime = (2 to 10000).filter(isPrime)
    val compositeSquare = (1 to 100).map(Math.pow(_, 2).toInt)

    val compositeNum = ((9 to 10000) diff compositePrime).filterNot(_%2==0)
    val res = ArrayBuffer.empty[Int]

    compositeNum.par.foreach {//parallelism .par
      elm =>
        val arr = new ArrayBuffer[(Int,Int)]
        for (i <- compositePrime; j <- compositeSquare) {
          if (elm == i + 2 * j) {
            result = elm
            arr.append((i, j))
          }
        }
        if(arr.isEmpty) res.append(elm)
    }
    println("min = "+res.min)
    val endTime = new Date().getTime
    println("time used  = "+(endTime - startTime))
  }
}
