package exercices.exercice_classe

import scala.util.control.Exception

/*
  Consigne : Implémenter une classe Tirelire qui possède un nom et un contenu
  On veut pouvoir passer le nom en argument, par défaut il doit valoir "Tirelire"
  La class doit avoir une méthode += qui permet d'augmenter la valeur du contenu de la tirelire
  La class doit avoir une méthode -= qui permet de réduire la valeur du contenu de la tirelire
  La class doit avoir une méthode vider qui permet de réinitialiser le contenu de la tirelire à 0
  La class doit avoir une méthode combien qui retourne le contenu de la tirelire
  La class doit avoir une méthode toString qui affiche le contenu de la tirelire et son nom

 */

object ClassExercice {
  def main(args: Array[String]): Unit = {
    val cochon = new Tirelire()
    println(cochon)
    val cochon2 = new Tirelire("A")
    println(cochon2)

    println(cochon)
    cochon += 100
    println(cochon)
    cochon += 10
    println(cochon)
    cochon vider()     /* équivalent de println(cochon.vider())  */
    cochon +=30
    println(cochon)
    cochon -= 50000
    println(cochon)
  }

  class Tirelire(){
    var nom :String = "TireLire"
    var conte:Int = 0

    // constructor
    def this(nom:String){
      this()
      this.nom = nom
    }

    // methods
    def +=(add:Int){
      conte+=add
    }

    def -=(sub:Int){
      if(sub<=conte)
        conte-=sub
      else throw(new Exception("Contenu is Not enough"))
    }

    def vider(): Unit ={
      conte = 0
    }

    def combien() :Int = conte

    override def toString:String = "Son nom : "+nom+", et son contenu = "+conte
  }
}
