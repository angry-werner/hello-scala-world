sealed trait Message

object Exit extends Message:
  val foo: String = "I'm exiting!"

case class Draw(val shape: String) extends Message

case class Response(val responseMessage: String) extends Message

val aFunction: Message => String = message => message match
  case Exit => Exit.foo
  case Draw(shape) => shape
  case Response(responseMessage) => responseMessage // Wird diese Methode weggelassen

val aPartialFunction: PartialFunction[Message, String] =
  case Exit => Exit.foo
  case Draw(shape) => shape
  case Response(responseMessage) => responseMessage // Kann weggelassen werden

val partialFunctionOnString: PartialFunction[Matchable, Boolean] =
  case matchable: String => true

val partialFunctionOnDouble: PartialFunction[Matchable, Boolean] =
  case matchable: Double => true

partialFunctionOnString("")

partialFunctionOnDouble(1.23)

partialFunctionOnString.isDefinedAt(1.23)

val partialFunctionOnStringAndDouble =
  partialFunctionOnString.orElse(partialFunctionOnDouble)

partialFunctionOnStringAndDouble("")
partialFunctionOnStringAndDouble(1.23)
partialFunctionOnStringAndDouble(true)

val liftedPF = partialFunctionOnStringAndDouble.lift
liftedPF(1.23)