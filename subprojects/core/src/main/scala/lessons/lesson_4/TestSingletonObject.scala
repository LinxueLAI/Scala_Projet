package lessons.lesson_4

/**
  * Define a Singleton object
  *
  * This function can be called from all the other classes of this project
  */
object TestSingletonObject {

  private var counter = 0

  def print_and_increment() : Unit = {
    counter+=1
    println(counter)
  }

}
