case class Channel(name: String)

case class Message(message: String)

sealed trait Action

case class Subscribe(channel: Channel) extends Action
case class UnSubscribe(channel: Channel) extends Action
case class Post(channel: Channel, message: Message) extends Action

val effectiveScalaChannel = Channel("effectiveScala")
