package projectEuler.exercices

object Problem25 {
  /*
    Problem 25 : 1000-digit Fibonacci number
    Description :
        The 12th term, F12, is the first term to contain three digits.
        What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
  */
  def main(args: Array[String]): Unit = {

    var first = BigInt(1)
    var second  = BigInt(2)
    var res = BigInt(0)
    var index = 2
    do{
      index+=1
      res = first+second
      first = second
      second = res
      println(s"the ${index}th fbn number = ${res}")
    }while(first.toString.sliding(1).size<1000)

    println(index)
  }

}
