package projectEuler.exercices

import java.util.Date
import scala.annotation.tailrec
import scala.collection.Seq

object Problem19 {
  /*
    Problem 19 : Counting Sundays
    Description :
        You are given the following information, but you may prefer to do some research for yourself.

        1 Jan 1900 was a Monday.
        Thirty days has September,
        April, June and November.
          All the rest have thirty-one,
        Saving February alone,
        Which has twenty-eight, rain or shine.
          And on leap years, twenty-nine.
          A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

        How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

        solution 1 :
          result: 171
          Time used = 252
   */
  var seqSundays = Seq.empty[Int]

  def isLeapYear(n: Int): Boolean = {
    n % 4 == 0 && n % 400 != 0
  }

  @tailrec
  def countSundays(year: Int): Seq[Int] = {
    if (year == 1900) {
      seqSundays
    }
    else {
      var sumSundays = 0
      var seqWeek = Seq.empty[Int]
      var indexLeapYear = 0

      val firstDayOfThisYear = firstDayOfYear(year)
      //println(s"first day of year ${year} is ${ firstDayOfThisYear}")
      if (isLeapYear(year)) indexLeapYear = 1
      (firstDayOfThisYear to firstDayOfThisYear + 365 + indexLeapYear).foreach(i =>
        seqWeek = seqWeek :+ (i % 7))
      if (seqWeek.head == 6)
        sumSundays += 1
      if (seqWeek(0 + 31) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31 + 30) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31 + 30 + 31) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31 + 30 + 31 + 30) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31 + 30 + 31 + 30 + 31) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31 + 30 + 31 + 30 + 31 + 31) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31 + 30 + 31 + 30 + 31 + 31 + 30) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31) == 6)
        sumSundays += 1
      if (seqWeek(0 + 31 + 28 + indexLeapYear + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30) == 6)
        sumSundays += 1
      seqSundays = seqSundays :+ sumSundays
      countSundays(year - 1)
    }
  }

  def firstDayOfYear(year: Int): Int = {
    val firstDayOf1900 = 0
    val leapYears = (1900 until year).filter(isLeapYear)
    val notLeapYears = (1900 until year).filterNot(isLeapYear)
    firstDayOf1900 + (leapYears.size * 366 + notLeapYears.size * 365 - 1) % 7
  }

  def main(args: Array[String]): Unit = {

    val startTime = new Date().getTime
    // Monday -> 0 Tuesday -> 1
    println("result: " + countSundays(2000).sum)
    val endTime = new Date().getTime
    println(s"Time used = ${endTime - startTime}")
  }
}
