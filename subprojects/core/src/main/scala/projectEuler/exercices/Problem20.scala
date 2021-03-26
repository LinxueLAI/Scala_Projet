package projectEuler.exercices

object Problem20 {
  /*
    Problem 20 : Factorial digit sum
    Description :
        n! means n × (n − 1) × ... × 3 × 2 × 1
        For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
        and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
        Find the sum of the digits in the number 100!
  */
  def main(args: Array[String]): Unit = {

    println(factorial(100).toString().map(_.asDigit).sum)

    def factorial(n: BigInt): BigInt = {
      if (n == 1)  n
      else  n*factorial(n - 1)
    }
  }

}
