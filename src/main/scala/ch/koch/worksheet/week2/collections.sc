import scala.collection.mutable

val foo = mutable.ArrayBuffer

foo.empty

List.empty

Map.empty[String, Boolean]

val bar: List[String] = List("a", "b")

val baz: Map[String, Boolean] = Map("a" -> true, "b" -> false)

val a: (String, Boolean, Int) = ("a", true, 5)
val b: (String, Int) = "b" -> 6

b match
  case (string, aNumber) => s"What $string? Amount: $aNumber."

val (x, y) = b

x

b(0)

"z" +: bar

bar :+ "z"

baz + ("c" -> true)

val someNumbers: List[Int] = List(0, 1, 2, 3, 4, 5)
val aFoundling: Option[Int] = someNumbers.find(aNumber => aNumber != 0 && aNumber % 2 == 0)
aFoundling.isEmpty

val noFoundling: Option[Int] = someNumbers.find(aNumber => aNumber == -1)
noFoundling.isEmpty

someNumbers.filter(aNumber => aNumber % 2 == 0)