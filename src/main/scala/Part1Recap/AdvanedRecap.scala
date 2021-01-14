package Part1Recap

object AdvanedRecap extends App {

  // partial functions
  val partialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 65
    case 5 => 999
  }

  val pf = (x: Int) => x match {
    case 1 => 42
    case 2 => 65
    case 5 => 999
  }

  val function: Int => Int = partialFunction

  val modifiedList = List(1, 2, 3).map {
    case 1 => 42
    case _ => 0
  }

  // lifting
  val lifted = partialFunction.lift // total function from Int to Option(Int)
  lifted(2) // Some(65)

  lifted(5000) // None

  //orElse
  val pfChain = partialFunction.orElse[Int, Int] {
    case 60 => 9000
  }

  pfChain(5) // 999
  pfChain(60) // 9000
  pfChain(546) // throw a matcher

  // type alaises
  type ReceiveFunction = PartialFunction[Any, Unit]

  def Receive: ReceiveFunction = {
    case 1 => println("hello")
    case _ => println("confused")
  }

  // implicits

  implicit val timeout = 3000
  def setTimeout(f: () => Unit)(implicit timeout: Int) = f()

  setTimeout(() => println("timeout")) // extra parameter list omitted compiler will pass the implicit parameter list for us

  // implicit conversions
  // 1) implicit defs
  case class Person(name: String) {
    def greet = s"Hi, my name is $name"
  }

  implicit def fromStringToPerson(string: String): Person = Person(string)

  "Peter".greet


}
