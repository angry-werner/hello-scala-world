case class Contact(name: String, phoneNumbers: List[String])

val alice: Contact = Contact("alice", "+41hrgur" :: "+39vjkgku" :: Nil)
val bob: Contact = Contact("bob", "+41owekro" :: Nil)
val carl: Contact = Contact("carl", "+39kfoawko" :: "+41cvhu" :: "+41karofko" :: Nil)

val result: List[(String, String)] =
  for
    contact <- alice :: bob :: carl :: Nil
    phoneNumber <- contact.phoneNumbers
    if phoneNumber.startsWith("+41")
  yield (contact.name, phoneNumber)

val flatMapResult: List[(String, String)] =
  (alice :: bob :: carl :: Nil)
    .flatMap {
      contact => contact
        .phoneNumbers
        .filter(phoneNumber => phoneNumber.startsWith("+41"))
        .map(phoneNumber => (contact.name, phoneNumber))
    }