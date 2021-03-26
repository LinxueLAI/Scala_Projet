package projectEuler.exercices

object Problem28 {
  /*
    Problem 28 : Number spiral diagonals
    Description :
          Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

                        21 22 23 24 25
                        20  7  8  9 10
                        19  6  1  2 11
                        18  5  4  3 12
                        17 16 15 14 13

          It can be verified that the sum of the numbers on the diagonals is 101.
          What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
  */
  def main(args: Array[String]): Unit = {

    val seq = Seq(2,4,6,8)
    var sum = 1
    (0 until 2).foreach(elm=> sum+=nthLayerSum(seq,elm))
    println(s"sum=${sum}")
    var result = 1
    (0 until 1001/2).foreach(elm=> result+=nthLayerSum(seq,elm))
    println(result)
  }

  def nthLayerSum(seq: Seq[Int],n:Int): Int={

    if (n == 0) seq.map(_.+(1)).sum
    else {
      seq.sum+nthLayerSum(seq = seq.map(_.+(8)),n-1)
    }
  }

}
