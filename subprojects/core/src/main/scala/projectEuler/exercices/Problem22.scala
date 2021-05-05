package projectEuler.exercices

import java.util.Date
import scala.io.Source

object Problem22 {
  /*
    Problem 22 : Names scores
    Description :
        Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
        For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
        What is the total of all the name scores in the file?

        Result = 871198282
        Time used = 502
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    val filename = "/home/llai/Téléchargements/scala-basic-learning/subprojects/core/src/main/scala/projectEuler/exercices/names.txt"
    for (line <- Source.fromFile(filename).getLines) {
      val seqWords: Seq[String] = line.split(",").sorted
      var worth: Seq[Long] = Seq.empty
      //      seqWords.foreach(name =>
      //        println(s"name:${name}'s worth =${name.slice(1,name.length-1).map(_.toInt-64).sum}")
      //      )
      seqWords.foreach(name =>
        worth = worth :+ name.slice(1, name.length - 1).map(_.toInt - 64L).sum
      )
      var result = 0L
      seqWords.indices.foreach(i => result += worth(i) * (i + 1))
      println(result)
    }

    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")
  }
}
