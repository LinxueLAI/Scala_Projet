package projectEuler.exercices

object Problem31 {
  /*
    Problem 31 : Coin sums
    Description :
        In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:

            1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).

        It is possible to make £2 in the following way:

            1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

        How many different ways can £2 be made using any number of coins?
  */
  def main(args: Array[String]): Unit = {
    val r = f(List(1, 2, 5, 10, 20, 50, 100, 200), 200)
    println(r)
  }


  def f(ms: List[Int], n: Int): Int = ms match {
    case premier_element :: tail =>
      if (premier_element > n) 0 else if (n == premier_element) 1 else f(ms, n - premier_element) + f(tail, n)
    case _ => 0
  }


}
