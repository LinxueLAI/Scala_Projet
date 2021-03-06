package projectEuler.exercices

import java.util.Date

object Problem24 {
  /*
    Problem 24 : Lexicographic permutations
    Description :
        A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
                        012   021   102   120   201   210
        What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

        Result = 2783915460
        Time used  = 589
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    println("0123456789".permutations.drop(999999).next())

    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }
}
