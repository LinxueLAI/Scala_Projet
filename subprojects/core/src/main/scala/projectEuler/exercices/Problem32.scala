package projectEuler.exercices

import java.util.Date

object Problem32 {
  /*
    Problem 32: Pandigital products
    Description :
        We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

        The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

        Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
        HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
        result = 45228
        time used  = 475

  */
  def main(args: Array[String]): Unit = {


    val startTime = new Date().getTime
    val ms = for {
      a <- 2 to 10000; b <- 2 to 10000 / a
      product = a * b
      s = a.toString + b.toString + product.toString
      if s.length == 9 && (1 to 9).mkString.forall(s.contains(_))
    } yield product

    println(s"result = ${ms.distinct.sum}")

    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }

}
