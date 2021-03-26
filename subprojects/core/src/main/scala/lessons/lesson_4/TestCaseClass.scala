package lessons.lesson_4

/**
  * Created by loick on 18/03/18.
  *
  * Define a case class
  */
case class TestCaseClass(
                          a : Int,
                          b: String
                        ) extends TestAbstractClass {


  override def sub(a: Int, b: Int): Int = {
    return a-b
  }


}
