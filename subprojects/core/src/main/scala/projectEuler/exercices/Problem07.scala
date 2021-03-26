package projectEuler.exercices

object Problem07 {
  /*
    Problem 7 : 10001st prime
    Description :
        By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
        What is the 10 001st prime number?
   */
  def main(args: Array[String]): Unit = {
    var seqPrime = Seq(0)
    var n = 2
    var counter = 1
    while(counter<10001){
      n+=1
      if(isPrime(n)){
        counter+=1
        seqPrime = seqPrime:+n
      }
    }
    println(seqPrime.size)
    println(seqPrime.max)
  }
  def isPrime(n: Int): Boolean = {
    val i = 2 to Math.sqrt(n).toInt
    i.find(k => n % k == 0 && k != n) match {
      case Some(_) => false
      case None => true
    }
  }

}
