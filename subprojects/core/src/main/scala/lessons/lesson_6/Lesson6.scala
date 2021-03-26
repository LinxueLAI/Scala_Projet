package lessons.lesson_6

import scala.util.Try

/**
  * Created by loick on 25/09/16.
  */

object Lesson6 {

  def main(args:Array[String]): Unit ={

    /*
    An option can take two values :
      - Some(...)
      - None
     */

    val a = Seq(1,2,3,4,10)
    val res: Option[Int] = a.find(elm => elm > 5)
    println(res)

    val b = "12 jaguars"
    val b_to_int: Option[Int] =
      Try {
        b.toInt
      }.toOption
    println(b_to_int)

    var optionStr : Option[String] = Some("apple")
    println(optionStr)

    if(optionStr.isDefined){
      println(s"\nprint if optionStr is defined : "+optionStr.get)
    }

    println(s"\nprint if optionStr is defined else print 'unknown': "+optionStr.getOrElse("unknown"))


    print(s"\nprint if optionStr is defined else print 'nothing': ")
    optionStr match {
      case Some(fruit) => println(fruit)
      case None => println("nothing")
    }

    optionStr.foreach(printIfIsDefined)
    println(optionStr.map(printIfIsDefined))

    print(s"\nprint if optionStr is defined else print 'nothing': ")
    optionStr = None
    optionStr match {
      case Some(fruit) => println(fruit)
      case None => println("nothing")
    }


    optionStr.foreach(printIfIsDefined)
    println(optionStr.map(printIfIsDefined))


    println(s"\nFor all the elements, print if is defined else print 'nothing':")
    val optionList : List[Option[String]] = List(Some("apple"),Some("orange"),Some("banana"),None)
    optionList.foreach {
      case Some(fruit) => println(fruit)
      case None => println("nothing")
    }


  }

  def printIfIsDefined(str: String): String ={
    println(str)
    str+str
  }
}
