package projectEuler.exercices

import exercices.exercice_nombres_premiers.NombresPremiers.{isPrime, primeNumberBuffer}

import java.util.Date
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Problem37 {
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
      solution 1 :
          result = 748317
          time used  = 5685
     */
        val arrTruncateNum = ArrayBuffer.empty[BigInt]
        var n = 11L
        do {
          if(isOptimizedPrime(n)){
            if(produceSeqRtoL(n).forall(isOptimizedPrime)&&produceSeqLtoR(n).forall(isOptimizedPrime)) {
              arrTruncateNum.append(n)
            }
          }
          n+=2
        }while(arrTruncateNum.length<11)
        println(s"result = ${arrTruncateNum.sum}")

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
    var i = primeNumberBuffer ++ s

    s.foreach{k=> if(isPrime(k)){primeNumberBuffer.add(k)}}
    i.find{k => n%k==0 &&k!=n}match {
      case Some(_) =>false
      case None =>true
    }
  }

}
