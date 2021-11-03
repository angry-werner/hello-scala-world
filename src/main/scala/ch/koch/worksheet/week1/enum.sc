enum Colours:
  case Red, Green, Blue

def isPreferredColour(colour: Colours): Boolean =
  colour match
    case Colours.Blue => true
    case _ => false

isPreferredColour(Colours.Blue)
isPreferredColour(Colours.Red)

Colours.values

sealed trait Sizes

object Sizes:
  case object S extends Sizes
  case object M extends Sizes
  case object X extends Sizes

  val values: Array[Sizes] = Array(S, M, X)

  def valueOf(name: String): Sizes =
    name match {
      case "S" => S
      case "M" => M
      case "X" => X
    }

Sizes.X

object Multiply:
  def multiply(a: Int, b: Int): Int =
    a * b