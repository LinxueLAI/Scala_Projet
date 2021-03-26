package projectEuler.exercices

object Problem05 {
  /*
    Problem 5 :  smallest multiple
    Description :
        2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
        What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
  */
  def main(args: Array[String]): Unit = {
    var n = 20
    while(!canBeDividedFrom1To20(n))
      n+=1
    println(n)
  }
  def canBeDividedFrom1To20(n : Int) : Boolean = (1 to 20).forall(i => n%i ==0)

}
