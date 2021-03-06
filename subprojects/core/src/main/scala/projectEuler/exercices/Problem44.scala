package projectEuler.exercices

import java.util.Date
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Problem44 {
  /*
    Problem 44 : Pentagon numbers
    Description :
      Pentagonal numbers are generated by the formula, Pn=n(3nā1)/2. The first ten pentagonal numbers are:
      1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
      It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their difference, 70 ā 22 = 48, is not pentagonal.
      Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and D = |Pk ā Pj| is minimised; what is the value of D?

      ArrayBuffer(5482660)
      time used  = 4198
  */

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    val arrayPentagonNum = mutable.HashSet[BigInt]()
    val diffPentagonNum = ArrayBuffer.empty[BigInt]

    (BigInt(1) to BigInt(10000)).foreach { n =>
      val pentagonNum = n * (3 * n - 1) / 2
      arrayPentagonNum.add(pentagonNum)
    }
    val arrayPentagonNumArray = {
      arrayPentagonNum.toArray.sorted
    }

    var k = 0
    for (i <- arrayPentagonNumArray.indices; j <- i until arrayPentagonNumArray.length if i != j) {
      val (elm0, elm1) = {
        (arrayPentagonNumArray(i), arrayPentagonNumArray(j))
      }
      k += 1
      val add = elm1 + elm0
      val diff = if (elm1 > elm0) elm1 - elm0 else elm0 - elm1
      if (arrayPentagonNum.contains(add) && arrayPentagonNum.contains(diff)) {
        diffPentagonNum.append(diff)
      }
    }
    //    println(s"K: ${k}")
    /*println(combinations.length)
    combinations.zipWithIndex.foreach{case(res,index)=>

      //if(index%10==0){
      println(s"${index}/${combinations.length}")
      //}
      val (elm0,elm1) = (res.head,res.last)
      val add = elm1+elm0
      val diff  = Math.abs(elm1-elm0)
      if (arrayPentagonNum.contains(add)&&arrayPentagonNum.contains(diff)) {
        println(s"${elm0},${elm1}")
        diffPentagonNum.append(diff)
      }
    }*/
    println(diffPentagonNum)
    val endTime = new Date().getTime
    println("time used  = " + (endTime - startTime))

  }
}
