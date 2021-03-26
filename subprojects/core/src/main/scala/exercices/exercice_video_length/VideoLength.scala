package exercices.exercice_video_length

import exercices.exercice_video_length.VideoLengthCorrection.longueur_to_seconds

object VideoLength {

  /*
  Consigne : Ecrire une fonction longueur_to_seconds(longeur) où longeur est une chaine de caractères
  sous la forme minutes:secondes qui retourne la longeur convertie en secondes
   Exemple :
     En entrée -  Durée : 5:33
     En sortie - Longueur en secondes : 333
     Cas particulier : si format invalide retourne -1

 */

  def main(args: Array[String]): Unit = {

    assert(longueur_to_seconds("01:00") == 60)
    assert(longueur_to_seconds("5:33") == 333)
    assert(longueur_to_seconds("61:00") == -1)
    println(longueur_to_seconds("5:30"))
    println(longueur_to_seconds("6:3"))
    println(longueur_to_seconds("5:65"))
    println(longueur_to_seconds("5rig:30"))
    println(longueur_to_seconds("100:00"))

    assert(longueur_to_seconds("01:00") == 60)
  }


  def longueur_to_seconds(longueur: String): Int = {
    var time = longueur.split(":")
    if(time(0).size>2||time(1).size>2) return -1
    val hour = time(0).toInt
    if(hour>59) return -1
    else{
      val min = time(1).toInt
      if(min>59) return -1
      else return hour*60+min
    }
  }
}