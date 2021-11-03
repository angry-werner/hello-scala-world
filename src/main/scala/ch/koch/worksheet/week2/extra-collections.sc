import scala.collection.mutable

(1 :: 2 :: 3 :: Nil) ++ (4 :: 5 :: 6 :: Nil)

val links: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer(1, 2, 3)
val rechts: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer(4, 5, 6)

links ++ rechts

links

rechts

links ++= rechts

links

rechts

links += 7

((1 :: 2 :: 3 :: Nil) ++ (4 :: 5 :: 6 :: Nil)).exists(aNumber => aNumber == 4)
((1 :: 2 :: 3 :: Nil) ++ (4 :: 5 :: 6 :: Nil)).forall(aNumber => aNumber == 4)
((1 :: 2 :: 3 :: Nil) ++ (4 :: 5 :: 6 :: Nil)).forall(aNumber => aNumber < 7)

val numbers: List[Int] = (1 :: 2 :: 3 :: Nil) ++ (4 :: 5 :: 6 :: Nil)
numbers(2)
numbers.apply(2)

val foo: (Int => Int) = (x => x * x)
foo(3)
foo.apply(3)

val data: List[(String, Int)] = ("a", 1) :: ("a", 2) :: ("b", 1) :: ("b", 3) :: Nil
val grouped: Map[String, Seq[Int]] = data.groupMap((key, value) => key)((key, value) => value)