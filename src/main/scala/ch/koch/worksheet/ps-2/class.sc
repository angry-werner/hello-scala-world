import java.util.Date
import scala.annotation.targetName

class Upper:
  def uppify(aString: String): String =
    aString.toUpperCase

val array: Array[String] = Array("Foo", "Bar", "Baz")

array(1) = "Barbar"

array

val seq: Seq[String] = array.toIndexedSeq

// seq(1) = "foo"

case class Whatever(foo: String, bar: String)

val whatever: Whatever = Whatever("a", "b")

// whatever.foo = "c"

class WhatElse(foo: String, bar: String)

val whatElse: WhatElse = WhatElse("a", "b")

class More(foo: String):
  def doIt(): String =
    foo
  end doIt
end More

class Human(val name: String, val dateOfBirth: Date)


val more: More = More("a")

more.doIt()

case class Point(x: Int = 0, y: Int = 0):
  def shift(deltaX: Int = 0, deltaY: Int = 0) =
    copy(x + deltaX, y + deltaY)

val nullPoint: Point = Point()
val xPoint: Point = Point(x = 5)
val yPoint: Point = Point(y = -13)

xPoint.shift(deltaX = -5)
yPoint.shift(deltaY = 26)

nullPoint.equals(xPoint.shift(deltaX = -5))

abstract class Shape():
  def draw(f: String => Unit): Unit =
    f(s"draw witout an origin: $this")
  @targetName("foo") def draw(origin: Point)(f: String => Unit): Unit =
    f(s"draw with an origin: $origin, shape = $this")
  @targetName("bar") def draw(origin: Point, f: String => Unit) =
    f(s"draw with an origin: $origin, shape = $this")

case class Circle(center: Point, radius: Double) extends Shape

case class Rectangle(lowerLeft: Point, height: Int, width: Int) extends Shape

case class Triangle(point1: Point, point2: Point, point3: Point) extends Shape:
  override def toString(): String =
    "No information on me today"


val triangle: Triangle = Triangle(Point(0,0), Point(1,0), Point(0,2))

s"A fucking triangle: $triangle"

sealed trait Message
case class Draw(shape: Shape) extends Message
case class Response(message: String) extends Message
case object Exit extends Message

object ProcessMessages:
  def apply(message: Message): Message =
    message match
      case Exit =>
        println(s"ProcessMessage: exiting...")
        Exit
      case Draw(shape) =>
        shape.draw(str => println(s"ProcessMessage with one argument: $str"))
        shape.draw(Point(3,4)) {
          str => println(s"ProcessMessage with two arguments in two separate braces: $str")
        }
        shape.draw(Point(3,4), str => println(s"ProcessMessage: $str"))
        Response(s"ProcessMessage: $shape drawn")
      case Response(unexpected) =>
        val response = Response(s"ERROR: Unexpected Response: $unexpected")
        println(s"ProcessMessage: $response")
        response


def ProcessShapesDriver =
  val messages = Seq(
    Draw(Circle(Point(0,0), 1)),
    Draw(Rectangle(Point(0,0), 2, 5)),
    Response(s"Say hello to pi: 3.14159"),
    Draw(Triangle(Point(0,0), Point(2,0), Point(1,2))),
    Exit)

  messages.foreach { message =>
    val response = ProcessMessages(message)
    println(response)
  }

ProcessShapesDriver