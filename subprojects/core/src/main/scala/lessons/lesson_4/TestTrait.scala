package lessons.lesson_4

/**
  * Created by loick on 18/03/18.
  *
  * Define a Trait
  */
trait TestTrait {


  // protected so can be used internally by son classes, but not externally
  protected val level = "info"


  def info(message:String) : Unit = {
    println(s"info: ${message}")
  }

  def error(message:String) : Unit = {
    println(s"error: ${message}")
  }

  def debug(message:String) : Unit = {
    println(s"debug: ${message}")
  }
}
