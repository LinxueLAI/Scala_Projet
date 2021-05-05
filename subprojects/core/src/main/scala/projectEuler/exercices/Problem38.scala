package projectEuler.exercices

import java.util.Date
import scala.collection.mutable

object Problem38 {
  /*
    Problem 38 : Pandigital multiples
    Description :
        Take the number 192 and multiply it by each of 1, 2, and 3:

            192 × 1 = 192
            192 × 2 = 384
            192 × 3 = 576

9  = 3+3+3  3-digit
9 = 1+2+2+2+2  1-digit
9 = 4 + 5  4-digit
        By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

        The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

        What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?

        result = 932718654
        time used  = 20903 = 21s
  */

  def main(args: Array[String]): Unit = {
//    à améliorer
    val startTime = new Date().getTime
    var max = 1

    val permutations = {
      val temp = mutable.HashSet[String]()
      "123456789".permutations.toSeq.foreach(e=> temp.add(e))
      temp
    }

    (9000 to 10000).par.foreach{
      num =>
        val seq: StringBuilder = new StringBuilder()
        (1 to 2).map(elm => num * elm).foreach(str => seq.append(str.toString))
        if(seq.length==9) {
          if (permutations.contains(seq.toString())) {
            println(s"seq = ${seq}")
            val found = seq.toInt
            max.synchronized{
              if(found>max) max = found
            }
          }
        }
    }
    println(s"result = ${max}")
    val endTime = new Date().getTime
    println("time used  = "+(endTime - startTime))
  }
}
