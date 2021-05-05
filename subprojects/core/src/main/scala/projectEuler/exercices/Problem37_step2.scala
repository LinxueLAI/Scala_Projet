package projectEuler.exercices

import java.util.Date
import scala.collection.mutable

object Problem37_step2 {
  /*
    Problem 37 : Truncatable primes
    Description :
      The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
      Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
      NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

  */

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    /*
        solution 2:
        result : 748317
        time used  =  1645
    */

    val one_digit_prime_hashset = {
      mutable.HashSet('3','5','7')
    }
    val result = {

      (11 to 800000 by 2)
        .par
        // We look if the last digit of the number is prime
        .filter(elm => one_digit_prime_hashset.contains(elm.toString.last))

        // We look if the head digit of the number is prime
        .filter(elm => one_digit_prime_hashset.contains(elm.toString.head))

        .filter { elm => produceSeqRtoL(elm).forall(isOptimizedPrime) }

        .filter { elm => produceSeqLtoR(elm).forall(isOptimizedPrime) }

        .sum
    }
    println(result)
    val endTime = new Date().getTime
    println("time used  = "+(endTime - startTime))
  }

  def produceSeqLtoR(n:BigInt):Seq[BigInt]={
    val res = n.toString()
    (0 until res.length).map{i=>
      BigInt.apply(res.substring(i,res.length))
    }
  }

  def produceSeqRtoL(n:BigInt):Seq[BigInt]={
    val res = n.toString()
    (1 until res.length).map{i=>
      BigInt.apply(res.substring(0,i))
    }
  }

  def isPrime(n: BigInt) :Boolean={
    if(n==1) return false
    val i = 2 to Math.sqrt(n.toInt).toInt
    i.find{k => n%k==0 &&k!=n}match {
      case Some(_) =>false
      case None =>true
    }
  }
  val primeNumberBuffer: mutable.SortedSet[BigInt] = {
    mutable.SortedSet[BigInt](2)
  }
  def isOptimizedPrime(n: BigInt) :Boolean={
    if(n==1) return  false

    val s = (primeNumberBuffer.max+1 to Math.sqrt(n.toInt).toInt)
    val i = primeNumberBuffer ++ s

    s.foreach{k=> if(isPrime(k)){primeNumberBuffer.add(k)}}
    i.find{k => n%k==0 &&k!=n}match {
      case Some(_) =>false
      case None =>true
    }
  }

}
