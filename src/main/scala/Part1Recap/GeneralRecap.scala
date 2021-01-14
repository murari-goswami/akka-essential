package Part1Recap

object GeneralRecap extends App {

  val aCondition: Boolean = false

  // expression
  val aConditionedVal = if (aCondition) 42 else 65

  // code block
  val aCodeBlock = {
    if (aCondition) 74
    56
  }

  // types
  // Unit
  val theUnit = println("hello scala")


  def aFunction(x: Int): Int = x + 1

  // recursion - TAIL RECURSION
  def factorial(n: Int, acc: Int): Int =
    if (n <= 0) acc
    else factorial(n - 1, acc * n - 1)

  // Functional - to make functions object
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  val incremented = incrementer(42)
  // incrementer.apply(42)

  val anonymousIncrementer = (x: Int) => x + 1
  // Int => Int ==== Function1[Int, Int]

  List(1, 2, 3).map(anonymousIncrementer)
  // map - higher order function

  // for comprehension
  val pairs = for {
    num <- List(1, 2, 3, 4)
    char <- List('a', 'b', 'c', 'd')
  } yield num + "--" + char

  // same as
  List(1, 2, 3, 4).flatMap(num => List('a', 'b', 'c', 'd').map(char => num + "- " + char))

  // pattern matching
  val unknown = 2
  val order = unknown match {
    case 1 => "first"
    case 2 => "second"
    case _ => "unknown"
  }
}
