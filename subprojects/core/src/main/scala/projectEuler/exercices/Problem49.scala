package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.isPrime

import java.util.Date
import scala.collection.mutable

object Problem49 {
  /*
    Problem 49  : Prime permutations
    Description :
      The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
      There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
      What 12-digit number do you form by concatenating the three terms in this sequence?

      distance = 3330
      result = 296962999629
      time used  = 1266
   */

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    (1000 until 10000).filter(isPrime).foreach{
      prime=>
        val permutations = {
          val temp = mutable.HashSet[String]()
          prime.toString.permutations.toSeq.foreach(e=> temp.add(e))
          temp
        }
        (1000 to 5000).foreach{
          distance =>
            val prime2 = prime+distance
            val prime3  =prime2+distance
            if(isPrime(prime2)&&isPrime(prime3)&&permutations.contains(prime2.toString)&&permutations.contains(prime3.toString)) {
              println(s"distance = ${distance}")
              println(prime.toString + prime2.toString + prime3.toString)
            }
        }
    }
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }

}
