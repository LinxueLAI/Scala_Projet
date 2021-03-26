package lessons.lesson_5

import scala.+:
import scala.collection.mutable.ArrayBuffer
import scala.collection.{immutable, mutable}

/**
  * Created by loick on 18/03/18.
  */
object Lesson5_a {
  // LES SEQUENCES

  def main(args: Array[String]): Unit = {

      val list1 = List(1,2,3,4,5)
      val list2 = List(6,7,8,9,10)

      println(s"\nlist1(2) = ${list1(2)}")

      println(s"\nlist2(3) = ${list2(3)}")

      println(s"\n\n\nlist1 + 6 = ${list1 :+ 6}")

      println(s"\nlist1 + list2 = ${list1++list2}")

      println(s"\nlist2 + list1 = ${list2++list1}")

      println(s"\n\n\nlist1 filter x!=3 = ${list1.filter(el => el!=3)}")

      println(s"\nlist1 filter x <3 = ${list1.filter(_<3)}")

      println(s"\nlist2 filterNot x>7 = ${list2.filterNot{el => el>7} }")

      println(s"\n\n\nSquare of list1 : ${list1.map{el => el*el}}")

      println(s"\nCube of list2 : ${list2.map(Math.pow(_,3))}")

      println(s"\n\n\nSort list2 + list1 : ${(list2++list1).sortBy(el => el)}")

      println(s"\n\n\nSort décroissant list2 + list1 : ${(list2++list1).sortBy(el => -el)}")

      println(s"\nSort list2 + list1 : ${(list2++list1).sorted}")

      println(s"\nReverse list2 : ${list2.reverse}")

      println(s"\nHead list2 : ${list2.head}")
      println(s"\nLast list2 : ${list2.last}")

      println(s"\nInit list2 : ${list2.init}")
      println(s"\nQueue list2 : ${list2.tail}")

      println(s"Deux listes zipées : ${list1.zip(list2)}")

      println(s"Tout les éléments de list1 sont pairs ? ${list1.forall(elm => elm%2==0)}")

      // On peut applatir une liste de liste avec la méthode "flatten"
      val list_of_list = Seq(
        Seq(1,2,3),
        Seq(4,5),
        Seq(6),
        Seq(7,8,9,10)
      )

      println(s"\nlist_of_list : ${list_of_list}")
      println(s"\nFlat list_of_list : ${list_of_list.flatten}")

      // On peut applatir une liste d'options avec la méthode "flatten" qui supprimera les "None"
      val list_of_options = Seq(
        Some(1),
        Some(12),
        None,
        Some(54)
      )

      println(s"\nlist_of_options : ${list_of_options}")
      println(s"\nFlat list_of_options : ${list_of_options.flatten}")


    // Pour appliquer une méthode à tout les éléments d'une liste, on peut utiliser .map()
    println((1 to 5).map( x => x*x ))
    println((1 to 5).map(_*2))


    def suite_au_carre(suite: Seq[Int]): Seq[Int] = {
      suite.map(toto => toto * toto)
    }

    println(suite_au_carre(Seq(12, 13, 14)))

    val les_saisons = Array("été", "automne", "hiver", "printemps")
    val les_saisons_majuscules = les_saisons.map(e => e.toUpperCase)
    les_saisons_majuscules.foreach(println)


    // Liste mutable
      val tab1 = ArrayBuffer[Int]()

      val tableauVide = Array.empty[Int]

      val tab2 = new ArrayBuffer[Int]
      tab1 += 25
      println(tab1)
      tab2 += (34, 75, 34, 90)
      println(tab2)
      tab2 insert(2, 34, 56, 78) /* insère les valeurs 34,56,78 à partir de la position 2 */
      println(tab2)
      tab2 ++= Array(4, 5, 6, 7) /* ajoute les éléments en fin de tableau */
      println(tab2)
      tab2.remove(4) /* retire le 5e élément */
      println(tab2)
      println(tab2.count(v => v % 2 == 0))

  }

}
