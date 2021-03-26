package projectEuler.exercices

import projectEuler.exercices.Problem34.factorial

import java.util.Date
import scala.collection.mutable.ArrayBuffer

object Problem34 {
//  Digit factorials

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    val list = ArrayBuffer(0,1,2)
//    println(s"initial list = ${list}")
    (3 to 100000).foreach {n =>
      val s =n.toString.map(elm =>factorial(elm.asDigit)).sum
//      println(s"n = ${n.toString},sum of n = ${s}")
      if(s == n) {
//        println(s"sum = ${s}")
        list.append(n)
      }
    }
//    println(s"there are ${list.length - 3} satisfy the conditions :${(3 until  list.length).foreach(elm =>println(list(elm)))}; result = ${list.sum -3}")
    println(s"result = ${list.sum-3}")
    val endTime = new Date().getTime
    println("time used  = "+(endTime - startTime))
  }

  def factorial(n: Int): Int = {
    if(n==0) 1
    else if (n<3)  n
    else  n*factorial(n - 1)
  }

}
