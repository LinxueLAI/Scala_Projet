package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.factorial

import java.util.Date

object Problem15 {
  /*
    Problem 15 : Lattice paths -> 20 parmi 40
    Description :
         How many such routes are there through a 20×20 grid?

          137846528820
          Time used = 273
    Remark : Be careful when we work with some big numbers!
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    println(factorial(40) / (factorial(20) * factorial(20)))

    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")
  }
}
