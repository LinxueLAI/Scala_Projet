package projectEuler.exercices

object Problem32 {
//  Pandigital products
  def main(args: Array[String]): Unit = {
    val ms = for {
      a <- 2 to 10000; b <- 2 to 10000 / a
      product = a * b
      s = a.toString + b.toString + product.toString
      if s.length == 9 && (1 to 9).mkString.forall(s.contains(_))
    } yield product

    println(s"result = ${ms.distinct.sum}")

  }

}
