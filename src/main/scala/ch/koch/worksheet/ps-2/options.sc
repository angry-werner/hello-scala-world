val hauptstaedte: Map[String, String] = Map(
  "Bern" -> "Bern",
  ("Aargau", "Aarau"),
  Tuple2("Basel Stadt", "Basel"))

hauptstaedte.getOrElse("Bern", "whatever")

hauptstaedte.getOrElse("Wallis", "whatever")

import java.util.HashMap as JHM

val javaMap: JHM[String, String] = JHM[String, String]()
javaMap.put("one", "1")

val one: String | Null = javaMap.get("one")

val two: String | Null = javaMap.get("two")

sealed abstract class MyOption[+A]

case class MySome[+A](a: A) extends MyOption[A]

case object MyNone extends MyOption[Nothing]

val aSome: MyOption[String] = MySome("Foo")

def example(anOption: MyOption[String]): Boolean =
  anOption match {
    case MySome(aString) => aString.equals("Foo")
    case MyNone => false
  }

example(aSome)
example(MySome("foo"))
example(MyNone)


