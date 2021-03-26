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
   */

  var seqSundays = Seq.empty[Int]

  def isLeapYear(n:Int) :Boolean = {
    n%4==0&&n%400!=0
  }

  @tailrec
  def countSundays(year:Int):Seq[Int]={

    if(year==1900){
      seqSundays
    }
    else{
      var sumSundays = 0
      var seqWeek = Seq.empty[Int]
      var indexLeapYear = 0

      val firstDayOfThisYear = firstDayOfYear(year)
      //println(s"first day of year ${year} is ${ firstDayOfThisYear}")
      if(isLeapYear(year)) indexLeapYear = 1
      (firstDayOfThisYear to firstDayOfThisYear+365+indexLeapYear).foreach(i=>
        seqWeek = seqWeek:+(i%7))
      if(seqWeek.head==6){
        sumSundays+=1
//        println("Jan")
      }
      if(seqWeek(0+31)==6){
        sumSundays+=1
//        println("Fev")
      }
      if(seqWeek(0+31+28+indexLeapYear)==6){
        sumSundays+=1
//        println("March")
      }
      if(seqWeek(0+31+28+indexLeapYear+31)==6) {
        sumSundays += 1
//        println("Apr")
      }
      if(seqWeek(0+31+28+indexLeapYear+31+30)==6) {
        sumSundays += 1
//        println("May")
      }
      if(seqWeek(0+31+28+indexLeapYear+31+30+31)==6) {
        sumSundays += 1
//        println("Jun")
      }
      if(seqWeek(0+31+28+indexLeapYear+31+30+31+30)==6) {
        sumSundays += 1
//        println("Jul")
      }
      if(seqWeek(0+31+28+indexLeapYear+31+30+31+30+31)==6) {
        sumSundays += 1
//        println("Aug")
      }
      if(seqWeek(0+31+28+indexLeapYear+31+30+31+30+31+31)==6) {
        sumSundays += 1
//        println("Sep")
      }
      if(seqWeek(0+31+28+indexLeapYear+31+30+31+30+31+31+30)==6) {
        sumSundays += 1
//        println("Oct")
      }
      if(seqWeek(0+31+28+indexLeapYear+31+30+31+30+31+31+30+31)==6) {
        sumSundays += 1
//        println("Nov")
      }
      if(seqWeek(0+31+28+indexLeapYear+31+30+31+30+31+31+30+31+30)==6) {
        sumSundays += 1
//        println("Dec")
      }
      seqSundays=seqSundays:+sumSundays

      countSundays(year-1)
    }

  }
  def firstDayOfYear(year : Int) : Int={
    val firstDayOf1900 = 0
    val leapYears = (1900 until year).filter(isLeapYear)
    val notLeapYears = (1900 until year).filterNot(isLeapYear)
    //println(s"leap years=${leapYears.size},they are: ${leapYears} \n not leap years = ${notLeapYears.size}, they are : ${notLeapYears}")
    firstDayOf1900+(leapYears.size*366+notLeapYears.size*365-1)%7
  }

  def main(args: Array[String]): Unit = {
    val startTime = new Date().getTime
    // Monday -> 0 Tuesday -> 1
//    println(isLeapYear(1900))//366 days
    println("result: "+countSundays(2000).sum+s"seqSunday: ${seqSundays}"+s"countYear = ${seqSundays.size}")
    println(seqSundays.sum)

    val endTime = new Date().getTime
    println(s"Time used = ${endTime-startTime}")
  }
}
