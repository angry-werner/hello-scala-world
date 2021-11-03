case class Contact(name: String, maybeEmail: Option[String], phoneNumbers: List[String])

val Alice: Contact = Contact("Alice", Some("alice@foo.bar"), "123" :: Nil)
val Bob: Contact = Contact("Bob", None, "456" :: Nil)
val Carl: Contact = Contact("Carl", Some("carl@foo.bar"), Nil)
val Desperate: Contact = Contact("Desperate", None, Nil)

def hasFooBarEmailAddress(contact: Contact): Boolean =
  contact.maybeEmail match
    case Some(email) => email.endsWith("@foo.bar")
    case None => false

hasFooBarEmailAddress(Alice)

def lengthOfFooBarEmailAddress(contact: Contact): Int =
  contact
    .maybeEmail
    .map(emailAddress => emailAddress.length)
    .getOrElse(0)

lengthOfFooBarEmailAddress(Alice)

Alice.maybeEmail.zip(Bob.maybeEmail.zip(Carl.maybeEmail))

def sendSms(number: String): Unit =
  println("SMS to: " + number)

def sendEmail(emailAddress: String): Unit =
  println("Email to: " + emailAddress)

(Alice :: Bob :: Carl :: Desperate :: Nil)
  .foreach(contact => contact.phoneNumbers.headOption match
    case Some(number) => sendSms(number)
    case None => contact.maybeEmail match
      case Some(emailAddress) => sendEmail(emailAddress)
      case None => println("No possibility to reach: " + contact.name)
  )

Alice +: List.empty
List.empty :+ Alice