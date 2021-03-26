package exercices.exercice_carrying_digits

import exercices.exercice_carrying_digits.CarryingDigitsCorrection.carrying_digits

/*
  Consigne : Ecrire une fonction carrying_digits(num1, num2) qui retourne le nombre de retenues
  lors de la somme entre num1 et num2
 */
object CarryingDigits {
  def main(args: Array[String]): Unit = {
    assert(carrying_digits(36, 135)==1)
    assert(carrying_digits(53214, 999956905)==7)

    println(carrying_digits(36, 135))
    println(carrying_digits(9671, 329))
    println(carrying_digits(1111, 3333))
    println(carrying_digits(53214, 956905))
    println(carrying_digits(53214, 999956905))
  }

  def carrying_digits(num1 : Int, num2 : Int) : Int = {
    var acc = 0
    var initRes = 0
    var res1 = num1
    var res2 = num2
    var res:Int = 0
    while(res1!=0&&res2!=0){
      var rest1 = res1%10
      var rest2 = res2%10
      res =  (rest1+rest2+initRes)/10
      acc+=res
      //println(acc)
      initRes = res

      res1 = res1/10
      res2 = res2/10
    }
    if(res == 0) acc
    else {
      var x = res1+res2
      while(x!= 0){
        var x1 = x%10
        if(x1==9) acc+=1
        x=x/10
      }
    }
    acc
  }
}
