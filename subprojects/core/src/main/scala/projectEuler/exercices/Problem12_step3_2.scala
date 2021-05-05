package projectEuler.exercices


import java.util.Date
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Problem12_step3_2 {
  /*
   Problem 12 : Highly divisible triangular number
   Description :
       We can see that 28 is the first triangle number to have over five divisors.
       What is the value of the first triangle number to have over five hundred divisors?
 */
  def main(args: Array[String]): Unit = {
    /*
    - Third step :
    Improve the algorithm -> calculate the composite factors of each triangle number and create a list for saving all the prime numbers which have been found before.

    Advantage : time complexity is reduced.

    result = 76576500
    Time used = 14722  (the use of ListBuffer takes more operations than the use of ArrayBuffer)

    REMARK : the use of ArrayBuffer, List AND Sequence
     */
    val startTime = new Date().getTime
    var nth = 1
    var triNumber = 2
    var nbOfFactors = 0
    do{

      triNumber = nth*(nth+1)/2
      val seqFactors = findAllPrimeFactors(triNumber)
      nbOfFactors = (0 to seqFactors.size).flatMap(seqFactors.combinations).map(_.product).distinct.size
      nth+=1
    }while(nbOfFactors<500)

    println(s"result = ${triNumber}")
    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")

  }

  val primeNumbers: ListBuffer[Int] = mutable.ListBuffer(2)

  def findAllPrimeFactors(n :Int):ArrayBuffer[Int]={
    var resNumber = n
    var factor = 2
    val seqFactors = ArrayBuffer(1)
    primeNumbers.indices.foreach{ nth =>
      factor = primeNumbers(nth)
      while(resNumber%factor==0){
        resNumber/=factor
        seqFactors.append(factor)
      }
    }
    factor = if (primeNumbers.size==1) 3 else factor+2
    while (resNumber>1){
      if(resNumber%factor==0)
        primeNumbers.append(factor)
      while (resNumber%factor==0){
        seqFactors.append(factor)
        resNumber/=factor
      }
      factor+=2
    }
    seqFactors
  }
}
