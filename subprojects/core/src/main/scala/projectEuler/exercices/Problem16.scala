package projectEuler.exercices

object Problem16 {
  /*
  Problem 16 :   Power digit sum
  Description :
        2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
        What is the sum of the digits of the number 2^1000?
  */
  def main(args: Array[String]): Unit = {
    var big = BigInt(1)
    (1 to 1000).foreach(_ => big = big*2)
    println(big.toString().map(_.asDigit).sum)
  }

}
