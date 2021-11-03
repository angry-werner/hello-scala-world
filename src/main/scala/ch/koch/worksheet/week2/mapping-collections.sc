val a: List[Int] = List(1, 2, 3, 5)

a.map(aNumber => aNumber * aNumber)

val b: Map[String, Int] = Map("a" -> 1, "b" -> 2)
b.map((a, b) => (a, b * b))
b.map((a, b) => (a + a, b))

a.flatMap(aNumber => List(aNumber, aNumber))
a.flatMap(aNumber => List())

case class Contact(name: String, phoneNumbers: List[String])
val alice: Contact = Contact("alice", List("123", "345"))
val bob: Contact = Contact("bob", List("567"))

val contacts: List[Contact] = List(alice, bob)
contacts.map(contact => contact.phoneNumbers)
contacts.flatMap(contact => contact.phoneNumbers)

List(1, 2, 3, 4, 5).foldLeft(0)((accumulator, aNumber) => accumulator + aNumber)
List(1, 2, 3, 4, 5).foldLeft("")((accumulator, aNumber) => accumulator + aNumber)

List(1, 2, 3, 4, 5).foldLeft(List.empty[Int])((accumulator, aNumber) => aNumber +: accumulator)

List(1, 2, 3, 4, 5).foldLeft(true)((accumulator, aNumber) => aNumber % 2 == 0)

def wtf (a: Int, b: Int) (c: Int, d: Int): Boolean =
  a * b == c * d

wtf (1, 2) (2, 1)

(1 :: 2 :: 3 :: 4 :: 5 :: Nil).foldLeft(0)((accumulator, aNumber) => accumulator + aNumber)

val aList = 1 +: 2 +: 3 +: 4 +: 5 +: List.empty[Int]

("a@sca.la" :: "b@sca.la" :: "c@foo.bar" :: Nil)
  .groupBy(name => name.dropWhile(aChar => aChar != '@').drop(1))