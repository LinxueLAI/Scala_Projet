package projectEuler.exercices

object Problem15 {
  /*
    Problem 15 : Lattice paths -> 20 parmi 40
    Description :
         How many such routes are there through a 20×20 grid?
  */
  def main(args: Array[String]): Unit = {
    //println(factorial(5))
    //println(factorial(40))
    println(factorial(40) / (factorial(20) * factorial(20)))

    def factorial(n: BigInt): BigInt = {
      if (n == 1)  n
      else  n*factorial(n - 1)
    }
  }
}
