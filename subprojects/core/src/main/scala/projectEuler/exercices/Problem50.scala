package projectEuler.exercices

import projectEuler.exercices.ProjetEulerUtils.isPrime

import java.util.Date

object Problem50 {
  /*
   Problem 50  : Consecutive prime sum
   Description :
      The prime 41, can be written as the sum of six consecutive primes:
      41 = 2 + 3 + 5 + 7 + 11 + 13
      This is the longest sum of consecutive primes that adds to a prime below one-hundred.
      The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
      Which prime, below one-million, can be written as the sum of the most consecutive primes?

      result :

      max sum = 997651
      time used  = 1052
  */

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    var sum = 0
    val seqPrime = (2 to 1000000).filter(isPrime)
    var index = 0

    do {
      sum += seqPrime(index)
      index += 1
    } while (sum < 1000000)

    val lastPrime = seqPrime(index - 1)
    sum = sum - lastPrime
    if (isPrime(sum))
      println(s"sum = ${sum}")
    else {
      val i = 0
      while (!isPrime(sum)) {
        sum -= seqPrime(i)
      }
      println(s"i = ${i},max sum = ${sum}")
    }

    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))
  }
}
