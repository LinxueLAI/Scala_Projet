package projectEuler.exercices

import java.util.Date

object Problem05 {
  /*
    Problem 5 :  smallest multiple
    Description :
        2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
        What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

        232792560
        time used = 4544
  */
  def main(args: Array[String]): Unit = {
    val startTime= new Date().getTime

    var n = 20
    while(!canBeDividedFrom1To20(n))
      n+=1
    println(n)

    val endTime= new Date().getTime
    println(s"time used = ${endTime - startTime}")

  }
  def canBeDividedFrom1To20(n : Int) : Boolean = (1 to 20).forall(i => n%i ==0)
}
