package lessons.lesson_1

/**
  * Created by loick on 27/02/18.
  *
  * Application to show how to create a runnable class with the "main" method.
  *
  * To run it with IntelliJ:
  *    1) Right Click + "Run Lesson_1a"
  *    2) CTRL + MAJ + F10
  *
  * To run it from command line:
  *
  *    1) 'sbt core/run' + choose the right number
  *    2) 'sbt "project core" "runMain lessons.lesson_1.Lesson1_a"
  *
  */

object Lesson1_a {

  /**
    * La fonction main est le point d'entrée dans le programme, c'est celle qui sera executée. Elle peut éventuellement
    * prendre des paramètres dans args
    * @param args séquence de paramètres
    */

  def main(args: Array[String]): Unit = {
    println("HelloWorld with main method")
  }
}
