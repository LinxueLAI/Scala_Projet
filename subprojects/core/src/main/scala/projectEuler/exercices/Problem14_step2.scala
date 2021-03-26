package projectEuler.exercices

import java.util.Date
import scala.collection.mutable.ArrayBuffer

object Problem14_step2 {
  /*
      Problem 14 :  Longest Collatz sequence
      Description :
          The following iterative sequence is defined for the set of positive integers:
                            n → n/2 (n is even)
                            n → 3n + 1 (n is odd)
          Using the rule above and starting with 13, we generate the following sequence:
                            13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
          It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem),
      it is thought that all starting numbers finish at 1.
          Which starting number, under one million, produces the longest chain?
          NOTE: Once the chain starts the terms are allowed to go above one million.
    */
  def main(args: Array[String]): Unit = {
    // To be improved :Time used = 518
    val startTime = new Date().getTime
    var counter: Int = 1
    var max = 1
    var cpt = 1
    while (counter<1000000){
      val longer = produceChain(counter)
      if(longer>max){
        max = longer
        cpt = counter
//        println(s"counter = ${counter}, max = ${max}")
      }
      counter+=1
    }
    println(cpt)
    val endTime = new Date().getTime
    println(s"Time used = ${endTime-startTime}")

  }
  def produceChain(n:Int):Int={
    var count = 1
    var tmp: Long = n.toLong
    while (tmp>1){
      if(tmp%2==0)
        tmp = tmp/2
      else
        tmp = tmp*3+1
      count+=1
    }
    count
  }
}
