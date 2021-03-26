package lessons.lesson_5

import scala.collection.mutable

object Lesson5_d {
  // LES SETS

  def main(args: Array[String]): Unit = {

    val palette = mutable.Set("blanc","rouge","vert","orange")   /* mutable est nécessaire si on met val */
    palette += "rose"

    println(palette)

    /* Une constante représente un et un seul objet, toujours le même. Mais cet objet peut changer d'état s'il est muable.
    Et même s'il change d'état, la constante n'a pas changé, elle représente toujours le même objet. Une constante peut
    aussi être un objet immuable dont l'état ne changera pas après sa création.
    Une variable peut contenir un objet immuable ou bien un objet muable.
     */


    val deuxieme_palette = Set("blanc","jaune")

    println(s"Union des deux palettes : ${palette union deuxieme_palette}")

    println(s"Intersection des deux palettes : ${palette intersect deuxieme_palette}")

    println(s"Difference entre les deux palettes : ${palette diff deuxieme_palette}")

  }
}
