package projectEuler.exercices

object Problem03 {
  /*
    Problem 3 :  Largest prime factor
    Description :
        The prime factors of 13195 are 5, 7, 13 and 29.
        What is the largest prime factor of the number 600851475143 ?
  */
  def main(args: Array[String]): Unit = {
//    first solution:
    println(s"result = ${maxPrimeFactor(600851475143L)}")
    def maxPrimeFactor(n:Long):Long={
      var factor = 2
      var res = n
      var lastFactor = 1
      while(res>1){
        if(res%factor==0){
          lastFactor = factor
          println(s"factor =${lastFactor}")
          res/=factor
          while (res%factor==0)
            res/=factor
        }
        factor+=1
      }
      lastFactor
    }

//    second solution:
    def factors(n:Long):List[Long] = (2 to math.sqrt(n).toInt)
      .find(n % _ ==0).fold(List(n))(i=> i.toLong :: factors(n/i))

    println(s"reslut = ${factors(600851475143L)}")
  }

}
