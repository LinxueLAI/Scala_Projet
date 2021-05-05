package projectEuler.exercices

import java.util.Date

object Problem25 {
  /*
    Problem 25 : 1000-digit Fibonacci number
    Description :
        The 12th term, F12, is the first term to contain three digits.
        What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

        Result  = 4782
        Time used  = 1181
  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    var first = BigInt(1)
    var second = BigInt(2)
    var res = BigInt(0)
    var index = 2
    var tmp = first.toString.sliding(1).size
    do {
      index += 1
      res = first + second
      first = second
      second = res
      tmp = first.toString.sliding(1).size
    } while (tmp < 1000)

    println(index)
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }


}
