sealed trait Shape

case class Circle(radius: Double) extends Shape

case class Square(width: Double) extends Shape

case class Rectangle(length: Double, width: Double) extends Shape

def area(shape: Shape): Double =
  shape match {
    case Circle(radius) => radius * radius * 3.1415
    case Square(width) => width * width
    case _ => -1
  }

val circle: Circle = Circle(5)
val square: Square = Square(4)

area(circle)
area(square)