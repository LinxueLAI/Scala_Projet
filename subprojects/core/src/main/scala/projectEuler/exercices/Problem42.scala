package projectEuler.exercices

import java.util.Date
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Problem42 {
  /*
      Problem 42 : Coded triangle numbers
      Description :
          The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
          1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
          By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
          Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?

    Result = 162
    Time used  = 323
    */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    var counter = 0
    val filename = "/home/llai/Téléchargements/scala-basic-learning/subprojects/core/src/main/scala/projectEuler/exercices/wordsP42.txt"
    for (line <- Source.fromFile(filename).getLines) {
      val str = line.split(",")
      str.foreach {
        word =>
          val sum: Int = word.init.substring(1).map {
            elm =>
              elm - 64
          }.sum
          val nth = math.sqrt(sum * 2).toInt
          if (nth * (nth + 1) / 2 == sum) counter += 1
      }
      println("result = " + counter)
    }

    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }

}
