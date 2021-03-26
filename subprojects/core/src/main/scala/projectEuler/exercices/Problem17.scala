package projectEuler.exercices

import org.apache.commons.csv.CSVRecord
import services.CSVManager

object Problem17 {
  /*
    Problem 17 : Number letter counts
    Description :
        If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
        If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
        NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
  */
  def main(args: Array[String]): Unit = {
    val csv_reader: Seq[CSVRecord] = CSVManager.load("/home/llai/Téléchargements/scala-basic-learning/subprojects/core/src/main/scala/projectEuler/exercices/number_to_words.csv")
    var sum = 0
    csv_reader.foreach{
      record =>
        sum+=record.get("english_word").count(char => char != ' ' && char != '-')
        println(record.get("english_word").filter(char => char!=' '&&char!='-'))
    }
    println(sum+3*(900-9))
  }
}
