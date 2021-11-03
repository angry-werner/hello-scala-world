val aList: List[String] = ("a" :: "b" :: "c" :: Nil)

aList.head

aList.tail

val tupleType = (String, Int)

val Alice: (String, Int) = "Alice" -> 23
val Bob: (String, Int) = "Bob" -> 42
val Carl: (String, Int) = "Carl" -> 12


val sortableList: List[(String, Int)] = Alice :: Bob :: Carl :: Nil

sortableList.sortBy((_, age) => age)

sortableList.sortBy((name, _) => name)

val searchableMap: Map[String, Int] = Map(Alice, Bob, Carl)

searchableMap.get("Alice").isEmpty

val l1 = List(1, 2, 3)
val l2 = List(4, 5, 6)
val l3 = l1 ++ l2