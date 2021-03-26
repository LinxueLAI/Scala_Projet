package exercices.exercice_building_word

/*
  Consigne : Ecrire une fonction can_build(words) qui retourne vrai si, pour chaque paire de mots
  consécutifs, on peut construire le second en ajoutant une seule lettre au début ou a la fin du premier mot
 */

object BuildingWord {
  def main(args: Array[String]): Unit = {
    println(can_build(Seq("art","cart","carte")))
    println(can_build(Seq("art","carte","cartes")))
    println(can_build(List("a", "at", "ate", "late", "plate", "plates")))
    println(can_build(List("a", "at", "ate", "late", "plate", "plater", "platter")))

    assert(can_build(Seq("art","cart","carte")))
    assert(!can_build(Seq("art","carte","cartes")))
    assert(can_build(List("a", "at", "ate", "late", "plate", "plates")))
    assert(!can_build(List("a", "at", "ate", "late", "plate", "plater", "platter")))

  }

  def can_build(words:Seq[String]) : Boolean = {
    val sizeSeq :Int = words.size
    var res :Boolean = true
    for(i<- 0 until sizeSeq-1) {
      if(words(i+1).slice(0,words(i+1).size-1) == words(i) || words(i+1).slice(1,words(i+1).size) == words(i))
        res = res&&true
      else {
        res = false
      }
    }
    res
  }
}
