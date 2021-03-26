package projectEuler.exercices

object Problem30 {
  /*
    Problem 30 : Digit fifth powers
    Description :
        The sum of these numbers is 1634 + 8208 + 9474 = 19316.

        Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
  */
  def main(args: Array[String]): Unit = {

    var limit = 1
    var end = 0
    var result = Seq.empty[Int]

    while (end<7){
      println(s"limit = $limit")
      val seq = limit.toString.map(_.asDigit)
      println(seq)
      end = seq.length

      if(seq.map(elm=> math.pow(elm,5)).sum == limit) {
        println("elm = " + limit)
        result = result :+ limit
      }
      limit+=1
    }
    println("result = " + result)
    println(result.sum-1)// 1 = 1^5 is not a sum, so it should not be included.
  }

}
