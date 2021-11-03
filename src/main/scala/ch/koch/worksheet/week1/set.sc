enum Shape:
  case Diamond, Oval, Squiggle

enum Colour:
  case Red, Green, Purple

enum Shading:
  case Solid, Striped, None

enum Number:
  case One, Two, Three

case class Card(shape: Shape, colour: Colour, shading: Shading, numberOfShapes: Number)

val deck: List[Card] = List(
  Card(Shape.Oval, Colour.Red, Shading.None, Number.One),
  Card(Shape.Diamond, Colour.Green, Shading.Solid, Number.Two),
  Card(Shape.Squiggle, Colour.Purple, Shading.Striped, Number.Three)
)

def checkAnyCondition(cards: List[Card], selector: Card => ?): Boolean =
  val counts: Int = cards.map(selector).toSet.size
  counts == 0 || counts == 3

def isValidSet(cards: List[Card]): Boolean =
  checkAnyCondition(cards, card => card.shape) &&
    checkAnyCondition(cards, card => card.colour) &&
    checkAnyCondition(cards, card => card.shading) &&
    checkAnyCondition(cards, card => card.numberOfShapes)

isValidSet(deck)