package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.compositePrimeFactors

import java.util.Date

object Problem12_step2 {
  /*
     Problem 12 : Highly divisible triangular number
     Description :
         We can see that 28 is the first triangle number to have over five divisors.
         What is the value of the first triangle number to have over five hundred divisors?
   */
  def main(args: Array[String]): Unit = {
    /*
    - Second step :
    Improve the algorithm -> calculate the composite factors of each triangle number instead of traversing from 1 to n for finding all the factors of n

    Advantage : time complexity is reduced.

    result : 76576500
    time used = 927

     */
    val startTime = new Date().getTime
    var nth = 1
    var triNumber = 2
    var nbOfFactors = 0
    do {
      triNumber = nth * (nth + 1) / 2
      val seq = compositePrimeFactors(triNumber)
      nbOfFactors = (1 to seq.size)
        .flatMap(seq.combinations)
        .map(_.product)
        .distinct
        .size
      nth += 1

    } while (nbOfFactors < 500)

    println(s"result : ${triNumber}")

    val endTime = new Date().getTime
    println(s"time used = ${endTime - startTime}")

  }
}
