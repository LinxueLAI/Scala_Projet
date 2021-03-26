package lessons.lesson_2

/**
  * Created by loick on 27/02/18.
  */
object Lesson2
{


  def main(args: Array[String]): Unit = {

    {
      /**
        * Here we will see how works a non final variable.
        * A non final variable is initialized with the keyword 'var'
        */

      // Initialization
      var non_final_variable = 0

      // print the variable
      println(non_final_variable)

      // Update the variable value
      non_final_variable = 1

      // print the new value
      println(non_final_variable)
    }







    {
      /**
        * Here we will see how works a final variable.
        * A final variable is initialized with the keyword 'val'
        */

      // Initialization
      val final_variable = 0


      /* The line below is commented because it makes the code not compiling.
    *  Indeed, the value of a final variable can not be modify with the operator '='.
    *  Try to uncomment this line to test it.
    */
      //final_variable = 1

    }







    {
      /**
        * Here we will see how works the strong typing of a variable.
        * A variable has always one type and it is not possible to modify this one.
        * When the type can be found implicitly, it is not mandatory to write it explicitly.
        */

      /*
    * Here the 'String' type is declared explicitly with the ':String'
    */
      var non_final_string_declared_explicitly: String = "I'm a string !"
      val final_string_declared_explicitly: String = "I'm a string !"


      /*
    * Here the 'String' type is declared implicitly, without using the ':String'
    */
      var non_final_string_declared_implicitly = "I'm a string !"
      val final_string_declared_implicitly = "I'm a string !"


      /* The lines below are commented because it makes the code not compiling.
    * Indeed we are trying to update the variables with a value that has a different type.
    * String != Int
    */
     // non_final_string_declared_explicitly = 1
     // non_final_string_declared_implicitly = 1

    }








    {

      /**
        * Here a list non exhaustive of basic scala types and how to instantiate them
        */


      val explicitly_string: String = "ddd"
      val implicitly_string = "qssqf"


      val explicitly_char: Char = 'd'
      val implicitly_char = 'd'


      val explicitly_int: Int = 1
      val implicitly_int = 1

      val explicitly_float: Float = 1.0f
      val implicitly_float = 1.0f


      val explicitly_double: Double = 1.0d
      val implicitly_double = 1.0d


      val explicitly_long: Long = 10L
      val implicitly_long = 10L


      val explicitly_array: Array[Int] = Array(1, 2, 3)
      val implicitly_array = Array(1, 2, 3)


      val explicitly_list: List[Int] = List(1, 2, 3)
      val implicitly_list = List(1, 2, 3)


      val explicitly_set: Set[Int] = Set(1, 2, 3)
      val implicitly_set = Set(1, 2, 3)


      val explicitly_map: Map[Int, String] = Map(1 -> "a", 2 -> "b")
      val implicitly_map = Map(1 -> "a", 2 -> "b")

    }

  }

/* VOIR AUSSI LESSON 5 */
}
