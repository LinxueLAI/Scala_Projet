package exercices.exercice_nombres_premiers

import upickle.Js.True

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


/*
  Consigne : Ecrire une fonction premiers(n) qui retourne la liste des nombres premiers inférieurs à n
 */

object NombresPremiers {

  def main(args: Array[String]): Unit = {

    //print(premiers(500000).size)
    //assert(premiers(500000).size == 41538)
    val primeBuffer =Array[Int](2)
    println(primeBuffer(0))
    println(isOptimizedPrime(179))
    println(primeNumberBuffer.mkString(","))
    println(isOptimizedPrime(197))
  }


  def premiers(n: Int): Seq[Int] = {
    (2 to n).filter(isPrime)
  }

  val primeNumberBuffer = {
    mutable.SortedSet[Int](2)
  }

//  var lastVisitedNumber = 1

  def isPrime(n: Int) :Boolean={
    var i = 2 to Math.sqrt(n).toInt
    i.find{k => n%k==0 &&k!=n}match {
      case Some(_) =>false
      case None =>true
    }
  }


  def isOptimizedPrime(n: Int) :Boolean={

    val s = (primeNumberBuffer.max+1 to Math.sqrt(n).toInt)
    var i = primeNumberBuffer ++ s

    s.foreach{k=> if(isPrime(k)){primeNumberBuffer.add(k)}}
    i.find{k => println(k); n%k==0 &&k!=n}match {
      case Some(_) =>false
      case None =>true
    }
  }





}
