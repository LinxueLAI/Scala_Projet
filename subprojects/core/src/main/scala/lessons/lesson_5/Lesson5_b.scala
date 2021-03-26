package lessons.lesson_5

object Lesson5_b {
  // LES TUPLES

  def main(args: Array[String]): Unit = {
    // Pour acceder à des tuples :
    val tuple = ("sylvain","jaguar","jeune loup")
    println(s"Premier elm ${tuple._1}, Deuxieme elm ${tuple._2}, Troisieme elm ${tuple._3}")

    val list_of_tuple = List(
      ("poipoi", 5),
      ("poipoi", 7),
      ("poipoi", 3),
      ("vaxou", 1),
      ("depinfo", 1),
      ("depinfo", 2),
      ("vaxou", 4)
    )

    println(s"\nSort list_of_tuple by word then number: ${list_of_tuple.sortBy{case(word,int) => (word, int)} }")

    println(s"\nSort list_of_tuple by number(asc) then word: ${list_of_tuple.sortBy(el => ( el._2, el._1))}")

    println(s"\nSort list_of_tuple by number(desc) then word: ${list_of_tuple.sortBy(el => ( -el._2, el._1))}")

    /* EXEMPLES D'APPARIEMENT */

    def SommeDiff(a: Int, b: Int) = (a + b, a - b)

    val (laSomme, laDifference) = SommeDiff(9, 20)
    println("somme = " + laSomme + " différence = " + laDifference)

    val enregistrement = ("alfred", "dupont", 45, "Paris", 0.567)
    val (prenom1, nom1, _, ville1, _) = enregistrement
    println(prenom1)
    println(ville1)

    val chef = ("alfred", "dupont")
    val enregistrement2 = (chef, 45, "Paris", 0.567)
    enregistrement2 match {
      case ((_, nom), _, ville, _) => println(nom + " habite " + ville)
    }

  }
}
