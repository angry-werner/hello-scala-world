trait Whatever

trait Enhanced extends Whatever:
  def doIt: String

case class Foo() extends Enhanced:

  def doIt: String =
    "Foo"
end Foo

case class Bar() extends Enhanced:

  def doIt: String =
    "Bar"
end Bar

case object Baz extends Whatever:
end Baz

def run(whatever: Whatever): String =
  whatever match
    case whatever: Enhanced => whatever.doIt
    case Baz => "Baz"

run(Bar())