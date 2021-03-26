package projectEuler.exercices

object Problem09 {
  /*
  Problem 9 : Special Pythagorean triplet
  Description :
      There exists exactly one Pythagorean triplet for which a + b + c = 1000.
      Find the product abc.
  */
  def main(args: Array[String]): Unit = {
    for(i<- 1 to 1000) {
      for (j <- 1 to 1000) {
        if (isOk(i,j)) {
          println("i:"+i+",j:"+j+",k:"+(1000-i-j))
          println(i*j*(1000-i-j))
        }
      }
    }
  }
  def isOk(a:Int,b:Int):Boolean={
    val c = 1000-a-b
    a*a+b*b == c*c
  }

}
