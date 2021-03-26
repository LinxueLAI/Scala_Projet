package lessons.lesson_8

/**
  * Created by loick on 25/09/16.
  */

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object Lesson8 {

  def main(args:Array[String]): Unit ={

    val list = (1 until 1000)

    // parallelize operations on List
    println("\n\nparallelize operations on list1")
    list.par.map(println)

    Thread sleep 1000

    //parallelize several operations with Futures
    println("\n\nparallelize several operations with Futures")
    val f1 = Future{
      list.slice(0, 300).sum
    }
    f1.onComplete{
      case Success(sum) => println(s"sum1 = ${sum}")
      case Failure(e) => e.printStackTrace()
    }


    val f2 = Future{
      list.slice(300, 600).sum
    }
    f2.onComplete{
      case Success(sum) => println(s"sum2 = ${sum}")
      case Failure(e) => e.printStackTrace()
    }

    val f3 = Future{
      list.slice(600, 1000).sum
    }
    f3.onComplete{
      case Success(sum) => println(s"sum3 = ${sum}")
      case Failure(e) => e.printStackTrace()
    }


    // With an aggregator
    val aggFut = for{
      f1Result <- f1
      f2Result <- f2
      f3Result <- f3
    } yield (f1Result, f2Result, f3Result)


    val tuple = Await.result(aggFut, Duration.Inf)
    println(s"\nThe tuple is ${tuple}")
    println(s"\nThe total sum is ${tuple._1+tuple._2+tuple._3}")


  }

}
