1 + 1

val x = 42

x * x

val facade: Int = 5 * 3
val door: Int = 1 * 2
facade - door

val outerDoor: Double = 1

def netFacadeArea(facade: Double, window: Double): Double =
  facade - outerDoor - window

netFacadeArea(2 * 3, 1)

def marathonDuration(speed: Double): Double =
  42 / speed * 60

marathonDuration(speed = 12)

def showPriceOrComment(price: Double): String =
  if price > 100 then
    "Too expensive"
  else
    price.toString

case class Rectangle(length: Double, width: Double):
  val area = length * width

val foo: Rectangle = Rectangle(2, 3)
foo.area

case class Square(width: Double):
  val area = width * width

val bar = Square(5).area

case class Circle(radius: Double):
  val area: Double = radius * radius * 3.1415

val baz = Circle(7).area



