package ch.koch.worksheet.week4.classes

import munit.FunSuite
import munit.ScalaCheckSuite
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

import ch.koch.worksheet.week4.classes.functions.add
import ch.koch.worksheet.week4.classes.functions.fibonacci


class ProgramSuite extends FunSuite:
  test("add") {
    assertEquals(add(1, 1), 2)
  }

  test("fibonacci 3") {
    assertEquals(fibonacci(3), 2)
  }

  test("fibonacci 4") {
    assertEquals(fibonacci(4), 3)
  }

  test("fibonacci 2") {
    assertEquals(fibonacci(2), 1)
  }

  test("fibonacci 0") {
    assertEquals(fibonacci(0), 0)
  }

  test("fibonacci -1") {
    intercept[IllegalArgumentException] {
      fibonacci(-1)
    }
  }

class ProgramProperties extends ScalaCheckSuite:
  property("fibonacci(n) == fibonacci(n - 1) + fibonacci(n - 2)") {
    forAll {
      (n: Int) =>
        val pn: Int = if n < 0 then -n else n
        val mpn: Int = if n < 3 then 2 else pn
        fibonacci(mpn) == fibonacci(mpn - 1) + fibonacci(mpn - 2)
    }
  }

  val fibonacciDomain: Gen[Int] = Gen.choose(1, 46)

  property("fibonacci(n) == fibonacci(n - 1) + fibonacci(n - 2) with generator") {
    forAll(fibonacciDomain.suchThat(n => n >= 3)) {
      (n: Int) => fibonacci(n) == fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  property("fibonacci(n) >= 0") {
    forAll(fibonacciDomain.suchThat(n => n >= 0)) {
      (n: Int) => fibonacci(n) >= 0
    }
  }

