package projectEuler.exercices

object Problem21 {
  /*
    Problem 21 : Amicable numbers
    Description :
        Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
        If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
        For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
        Evaluate the sum of all the amicable numbers under 10000.
  */
  def main(args: Array[String]): Unit = {

    println(amicableNumbers.sum)
    def amicableNumbers:Seq[Int]={
      var seqAmicableNumbers = Seq.empty[Int]
      for(i<- 1 until 10000){
        val sum = sumOfDivisors(i)
        if(sum!=i && sumOfDivisors(sum)==i){
          //println(s"i = ${i}, j =${sum} ")
          if(!seqAmicableNumbers.contains(i)) seqAmicableNumbers=seqAmicableNumbers:+i
          if(!seqAmicableNumbers.contains(sum)) seqAmicableNumbers=seqAmicableNumbers:+sum
        }
      }
      seqAmicableNumbers

    }
    //println(sumOfDivisors(220))
    //println(sumOfDivisors(284))
    def sumOfDivisors(n:Int):Int={
      var seqDivisors = Seq(1)
      (2 to Math.sqrt(n).toInt).foreach(i=>
        if(n%i==0)
          {
            if(n==i*i) seqDivisors = seqDivisors:+i
            else seqDivisors = seqDivisors:+i :+n/i
          }
      )
      seqDivisors.sum
    }

  }

}
