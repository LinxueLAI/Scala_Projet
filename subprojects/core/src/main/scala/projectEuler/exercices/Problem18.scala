package projectEuler.exercices

import java.util.Date
import scala.annotation.tailrec

object Problem18 {
  /*
    Problem 18 : Maximum path sum I
    Description :
        By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

        That is, 3 + 7 + 4 + 9 = 23.

        Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

Result = 1074
Time used = 318

  */
  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime

    val tree: Array[Array[Int]] = "75\n95 64\n17 47 82\n18 35 87 10\n20 04 82 47 65\n19 01 23 75 03 34\n88 02 77 73 07 63 67\n99 65 04 28 06 16 70 92\n41 41 26 56 83 40 80 70 33\n41 48 72 33 47 32 37 16 94 29\n53 71 44 65 25 43 91 52 97 51 14\n70 11 33 28 77 73 17 78 39 68 17 57\n91 71 52 38 17 14 91 43 58 50 27 29 48\n63 66 04 68 89 53 67 30 73 16 69 87 40 31\n04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"
      .split("\n")
      .map(_.split(" ").map(_.toInt))
    //    println(s"bottom= ${tree.last.toSeq}")
    val r = f(tree.init, tree.last.toSeq)
    println(s"r = $r")

    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")

  }

  @tailrec
  def f(rows: Array[Array[Int]], bottom: Seq[Int]): Int = {
    val ms = bottom.zip(bottom.tail).map(p => p._1 max p._2)
    //    println(bottom.zip(bottom.tail))
    val ss = rows.last.zip(ms).map(p => p._1 + p._2)
    if (ss.length == 1) ss.head else f(rows.init, ss)
  }
}
