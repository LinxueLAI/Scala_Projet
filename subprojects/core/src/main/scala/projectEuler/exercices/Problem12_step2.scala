package projectEuler.exercices

import java.util.Date

object Problem12_step2 {
  /*
     Problem 12 : Highly divisible triangular number
     Description :
         We can see that 28 is the first triangle number to have over five divisors.
         What is the value of the first triangle number to have over five hundred divisors?
   */
  def main(args: Array[String]): Unit = {
    /*
    - Second step :
    Improve the algorithm -> calculate the composite factors of each triangle number instead of traversing from 1 to n for finding all the factors of n

    Advantage : time complexity is reduced.

    result : 76576500
    time used = 1065

     */
    val startTime= new Date().getTime
    var nth = 1
    var triNumber = 2
    var nbOfFactors = 0
    do{
      triNumber = nth*(nth+1)/2
      val seq = compositePrimeFactors(triNumber)
      nbOfFactors = (1 to seq.size).flatMap(seq.combinations).map(_.product).distinct.size
      nth+=1

    }while(nbOfFactors <500)

    println(s"result : ${triNumber}")
    val endTime= new Date().getTime
    println(s"time used = ${endTime - startTime}")

  }

  def compositePrimeFactors(n:Int):Seq[Int] = {
    var seqPrimeFactors = Seq(1)
    var factor = 2
    var res = n
    while(res%factor==0) {
      seqPrimeFactors = seqPrimeFactors:+2
      res /= 2
    }
    factor = 3
    while (res>1){
      while (res%factor==0){
        seqPrimeFactors = seqPrimeFactors:+factor
        res /= factor
      }
      factor+=2
    }
    seqPrimeFactors
  }
}
