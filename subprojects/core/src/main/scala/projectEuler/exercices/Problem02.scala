package projectEuler.exercices

import scala.collection.immutable.StreamView

object Problem02 {
  /*
     Problem 2 : Even Fibonacci numbers
     Description :
        Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
        By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
   */
  def main(args: Array[String]): Unit = {
//    first solution:
    println(s"sum = ${fibonacci(4000000)}")
    def fibonacci(n:Int):Int={
      if(n==1||n==2)
        2
      else {
        var a = 1
        var b = 2
        var c = a+b

        var sum=2
        while(c<n){
          if(c%2==0) {
            sum+=c
            println(c)
          }
          a = b
          b = c
          c = a+b
        }
        sum
      }
    }

//    second solution:
    lazy val fs : Stream[Int] = 1#::fs.scanLeft(2)(_+_)
    val r: StreamView[Int, Stream[Int]] = fs.view.takeWhile(_<= 4000000).filter(_%2==0)
    println {
      r.sum
    }

  }

}