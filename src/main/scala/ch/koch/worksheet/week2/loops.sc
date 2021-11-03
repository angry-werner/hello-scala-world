def factorial(number: Integer): Integer =
  (1 to number).foldLeft(1)((accumulator, aNumber) => accumulator * aNumber)

factorial(10)

def standardBasedFactorial(number: Integer): Integer =
  (1 to number).product

standardBasedFactorial(10)

1 to 4
1 until 4

def imperativeFactorial(aNumber: Integer): Integer =
  var i: Integer = 1
  var accumulator: Integer = 1
  while i < aNumber do
    i += 1
    accumulator *= i
  accumulator

imperativeFactorial(10)

def recursiveFactorial(aNumber: Integer): Integer =
  if aNumber == 1 then 1
  else aNumber * recursiveFactorial(aNumber - 1)

recursiveFactorial(10)

def tailRecursiveFactorial(aNumber: BigInt): BigInt =
  def tailRecursiveFactorial(aNumber: BigInt, accumulator: BigInt): BigInt =
    if aNumber == 0 then accumulator
    else tailRecursiveFactorial(aNumber -1, aNumber * accumulator)
  tailRecursiveFactorial(aNumber, 1)

tailRecursiveFactorial(100_000)