package ch.koch.worksheet.week4.classes.functions

import scala.annotation.tailrec

def add(a: Int, b: Int): Int =  a + b

def fibonacci(n: Int): Int =
  @tailrec
  def fibonacci(i: Int, sum: Int, previousSum: Int): Int =
    val newSum = sum + previousSum
    if i >= n then
      newSum
    else
      fibonacci(i + 1, newSum, sum)

  if n < 0 then
    throw new IllegalArgumentException
  n match
    case 0 => 0
    case 1 => 1
    case 2 => 1
    case _ => fibonacci(3, 1, 1)

object Example:
  @main def run(): Unit =
    for i <- 0 to 9 do println(fibonacci(i))
