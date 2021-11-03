case class Contact(name: String, email: String, phoneNumbers: List[String])

case class AddressBook(contacts: List[Contact])

val alice: Contact = Contact("Alice", "alice@example.com", List())
val bob: Contact = Contact("Bob", "bob@example.com", List("+41 12 345 67 89"))

val addresses: AddressBook = AddressBook(List(alice, bob))

addresses.contacts.size

addresses.contacts.contains(alice)

addresses.contacts.map(contact => contact.name)

addresses.contacts.filter(contact => contact.phoneNumbers.nonEmpty)

val moreAddresses: List[Contact] = Contact("Carol", "carol@example.org", List()) :: addresses.contacts

def split(addressBook: AddressBook): Unit =
  addressBook.contacts match
    case contact :: tail => println(contact.name)
    // case first :: second :: tail => println(second.name)
    case Nil => println("No second")

split(addresses)

addresses.contacts.head

addresses.contacts.tail.head

addresses.contacts.tail.tail