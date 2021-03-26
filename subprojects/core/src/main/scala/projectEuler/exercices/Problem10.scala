package projectEuler.exercices

object Problem10 {
  /*
    Problem 10 : Summation of primes
    Description :
        The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
        Find the sum of all the primes below two million.
  */
  def main(args: Array[String]): Unit = {
    println((2 to 2000000).filter(isPrime).map(_.toLong).sum)
  }

  def isPrime(n: Int): Boolean = {
    val i = 2 to Math.sqrt(n).toInt+1
    i.find(k => n % k == 0 && k != n) match {
      case Some(_) => false
      case None => true
    }
  }

}
