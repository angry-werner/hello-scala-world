import scala.annotation.tailrec

def factorial(i: Int): BigInt =
  @tailrec
  def fact(i: Int, accumulator: BigInt): BigInt =
    if i <= 1 then accumulator
    else fact(i - 1, i * accumulator)

  fact(i, BigInt(1))

(0 to 5).foreach(i => println(s"$i: ${factorial(i)}"))

def countTo(n: Int): Unit =
  @tailrec
  def count(i: Int): Unit =
    if (i <= n) then
      println(i)
      count(i + 1)
  count(1)

countTo(5)