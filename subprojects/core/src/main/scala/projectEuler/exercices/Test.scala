package projectEuler.exercices

import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.ForkJoinTaskSupport

object Test {
  def main(args: Array[String]): Unit = {


    val buffer = ArrayBuffer[Int]()
    val par_seq = (0 to 10).par

    par_seq.tasksupport = {
      new ForkJoinTaskSupport(
        new java.util.concurrent.ForkJoinPool(8)
      )
    }

      par_seq
      .foreach{i=>
        buffer.synchronized {
          buffer.append(i)
        }
    }

    println(buffer)


  }

}
