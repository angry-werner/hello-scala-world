val increment: Int => Int =
  x => x + 1

val add: (Int, Int) => Int =
  (a, b) => a + b

add(1, increment(2))