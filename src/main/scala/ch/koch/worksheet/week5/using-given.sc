import scala.language.postfixOps

trait Bar[T]:
  def bar(x: T): String
  extension (leftHandSide: T)
    def augmentPost: String = bar(leftHandSide)

object Bar {
  given Int: Bar[Int] with
    def bar(x: Int): String = "From Int: " + x.toString

  given Bar[Double] with
    def bar(x: Double): String = "From Double: " + x.toString
}

class Foo {
  def foo[T](x: T)(using bar: Bar[T]): String =
    (x augmentPost) + bar.bar(x)
}

Foo.apply().foo(5)

Foo.apply().foo(1.2)

summon[Bar[Int]].bar(1)

extension [A] (a: A)
  def ~> [B](b: B): (A, B) = (a, b)

"foo" ~> 1

case class Num(value: Int)

given n: Num = Num(42)
def f(using x: Num): Int = x.value

println(f)

case class Num(value: Int)

given n: Num = Num(42)
def f(using x: Num): Int = x.value

println(f(using Num(0)))

case class Name(text: String)

given world: Name = Name("World")
def greet(using name: Name) = s"Hello, ${name.text}!"
println(greet)

trait Show[A]:
  def apply(a: A): String

object Show:
  given showInt: Show[Int] with
    def apply(n: Int): String = s"Int($n)"

summon[Show[Int]]

def printValue[A: Show](a: A): Unit =
  println(summon[Show[A]].apply(a))

printValue(42)

def sort[A](as: List[A])(using ordering: Ordering[A]): List[A] = {
  // Hier müsste sortiert werden
  as.foldLeft(List.empty[A])((resultList, anElement) => anElement +: resultList)
}

def otherSort[A: Ordering](as: List[A]): List[A] = {???}

val result = sort(List(1, 2))

val otherResult = sort(List(1.2, 2.3))(using Ordering[Double])

case class Foo(a: String)
case class Bar(b: String)

val foo: (Foo => Bar) = (x) => Bar(x.a)
