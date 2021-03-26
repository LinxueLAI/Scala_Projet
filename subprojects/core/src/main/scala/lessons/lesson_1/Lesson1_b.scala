package lessons.lesson_1

/**
  * Created by loick on 27/02/18.
  *
  * Application to show how to create a runnable object with the "App" extension.
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

/**
  * Ici pas de fonction main, car l'object étend la classe App. Donc tout ce qui est à l'interieur de l'objet sera
  * executé
  * En pratique on préfère utiliser une fonction main plutôt que d'étendre App, car cela permet de voir plus clairement
  * ce qui est executé
  */
object Lesson1_b extends App {

  println("HelloWorld with App extension")

}
