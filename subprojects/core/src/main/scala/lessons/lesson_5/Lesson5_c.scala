package lessons.lesson_5

import scala.collection.{immutable, mutable}

object Lesson5_c {
  // LES MAPS

  def main(args: Array[String]): Unit = {

    val map2 = mutable.Map[String,Int]( "a" -> 1, "b" -> 2)
    map2("eee") = 1

    println(s"Map2 :  ${map2}")


    var map = immutable.Map[String,Int]( "a" -> 1, "b" -> 1)


    println(map)

    println(map("a"))
    map += ("c" -> 4)

    map += ("c" -> 3)
    println(map)

    println(s"\nmap(c) = ${map.getOrElse("c",0)}")

    println("\nmap(d) = " + map.getOrElse("d",0))

    println("\nkeys :" + map.keys)

    println("\nvalues :" + map.values)

    val mapDesNombres = Map("un" -> 1, "deux" -> 2, "trois" -> 3, "quatre" -> 4)


    mapDesNombres foreach { case(cle, valeur) => println(cle + " " + valeur) }

    val mapInverse = for ((cle, valeur) <- mapDesNombres) yield (valeur, cle)
    mapInverse foreach { case (cle, valeur) => println(cle + " " + valeur) }

    /* Découpage d'une Map */
    val (mapPaire, mapImpaire) = mapDesNombres.partition(_._2 % 2 == 0)
    mapImpaire foreach { case (cle, valeur) => println(cle + " " + valeur)
    }

  }
}
