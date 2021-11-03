val tuple: (String, Int, Double) = ("Foo", 1, 2.0)

val anotherTuple = (tuple._1, "Bar", tuple(2))

val (titi: String, tata, toto) = tuple

val yetAnothetTuple: (Int, String) = tuple._2 -> anotherTuple(0)

Tuple2(tuple(0), tuple._2)
