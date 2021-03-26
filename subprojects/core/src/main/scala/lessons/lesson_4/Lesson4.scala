package lessons.lesson_4


object Lesson4 {

  def main(args: Array[String]): Unit = {

    {
      /*
      A "normal" class has to be initialized with the new keyword
      For this type of class, the toString method is not set, so it is not possible
      to print this class
       */
      val testClass = new TestClass(1, "ert")
      println("I'm a normal class, here the result when I'm printed:")
      println(testClass)

      {
        // I can access to the functions defined in the Trait
        testClass.info("info")
        testClass.debug("debug")
        testClass.error("error")
      }
    }


    {
      /*
      A "case" class can to be initialized with or without the new keyword
      For this type of class, the toString method is set by default, so it is possible
      to print this class directly
       */
      val testCaseClass = TestCaseClass(2, "toto")
      println("\nI'm a case class, here the result when I'm printed:")
      println(testCaseClass)

      {
        // I can access in the function defined in the abstract class
        testCaseClass.sub(1,3)
        testCaseClass.add(2,4)

      }
    }

    {
      // Use a singleton
      println("\nHere result of the singleton object method")
      TestSingletonObject.print_and_increment()
    }


  }


  // Exemple 1




  // Exemple 2 avec une case class
  case class BankAccount() {
    private var balance: Int = 0
    def deposit(amount: Int): Int = {
      if (amount > 0) {
        balance += amount
      }
      balance
    }

    def withdraw(amount: Int): Int =
      if (0 < amount && amount <= balance) {
        balance -= amount
        balance
      } else throw(new Exception("insufficient funds"))
  }

}
