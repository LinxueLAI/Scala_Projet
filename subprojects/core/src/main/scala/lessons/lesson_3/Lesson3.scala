package lessons.lesson_3
import Ordering.Implicits._  /* pour dernier programme */
/**
  * Created by loick on 25/09/16.
  */
object Lesson3 {

  def main(args:Array[String]): Unit ={

    {
      /**
        * Here we will see how works the if condition.
        */

      val j: Int = scala.util.Random.nextInt(9)
      println(j)


      val word = if (j == 1) {
        "abc"
      } else if (j != 1 && j >= 4) {   /* && désigne le ET */
        "def"
      } else if (j == 3 || j == 2) {   /* || désigne le OU  */
        "ghi"
      } else {
        "jkl"
      }

      println(word)

      val number = word match{
        case "abc" => 1
        case ("def"|"ghi") => 2      /* | désigne le OU dans un match case */
        case _ => 3                 /* _ désigne n'importe quelle valeur */
      }
      println(number)

    }

    {
      /**
        * Here we will see how works the for loops.
        */

      for (i <- 0 to 10) {
         println(i)
      }

      for (i <- 0 until 10) {
         println(i)
      }


      for (i <- 0 until 10; j <- 0 to 2) {
         println(i + " - "+ j)
      }

      for (i <- 0 to 10; j <- 0 to i; if i != j) {
         println(i + " - "+ j)
      }


      (1 to 10).foreach { i =>
        println(i)
      }
      (1 to 10 by 2).foreach { i =>
        println(i)
      }
      (1 until 10).foreach { i =>
        println(i)
      }

    }


    {
      /**
        * Here we will see how works the while loop
        */

      var k = 0

      while (k < 10) {
        println(k)
        k += 1
      }


      do{
        println(k)
        k+=1
      } while(k<20)
    }



    {
      /**
        * Here we will see how works the try/catch/finally blocks
        */

      val null_str: String = null
      try {
        null_str.contains("a")
        println(1/0)
      } catch {
        case e: java.lang.NullPointerException => println("null pointer exception")  /* NullPointerException quand on essaye d'appeler la méthode contains sur un object null */
        case e: Throwable => println("other exception")
      } finally {
        println("finally")
      }

    }

    val a = Seq(1, "un")
    val random_elem: Any = a(scala.util.Random.nextInt(2))

    random_elem match {
      case element : Int=>  println("Je suis un Int")
      case element : String => println("Je suis un String")
      case _ => println("Je suis autre chose")
    }

    println(estSuperieur(5,7))
    println(estSuperieur("papa","maman"))

    def estSuperieur[T : Ordering](x:T,y:T):Boolean = x > y

  }

}
