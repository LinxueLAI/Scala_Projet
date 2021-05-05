package projectEuler.exercices

import java.util.Date
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Problem39 {
  /*
    Problem 39 : Integer right triangles
    Description :

        If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

        {20,48,52}, {24,45,51}, {30,40,50}

        For which value of p ≤ 1000, is the number of solutions maximised?
        result : 840
        time used  = 582

  */

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    var maxSolution = 1
    var result = 0
    (4 to 1000).par.foreach { p =>
      val tmp = nbOfSolution(p)
      if (tmp > maxSolution) {
        maxSolution = tmp
        result = p
      }
    }
    println(s"result : ${result}")
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }

  def nbOfSolution(p: Int): Int = {
    val result = new mutable.ListBuffer[(Int, Int, Int)]
    (1 until p / 2).foreach {
      a =>
        (1 until p / 2).foreach { b =>
          val c = p - a - b
          if (a + b > c && a * a + b * b == c * c) result.append((a, b, c))
          if (a + c > b && a * a + c * c == b * b) result.append((a, c, b))
          if (c + b > a && c * c + b * b == a * a) result.append((c, b, a))
        }
    }
    result.distinct.sorted.length
  }
}
