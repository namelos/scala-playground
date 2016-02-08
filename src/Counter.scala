
object Counter {
  def sumOfSqaures(x: Int, y: Int): Int = {
    val x2 = x * x
    val y2 = y * y
    x2 + y2
  }

  def sumOfSquaresShort(x: Int, y: Int): Int = x * x + y * y
  def subtract(x: Int, y: Int): Int = x - y
  def sq(x: Int) = x * x
  def addWithDefault(x: Int, y: Int = 5) = x + y

  val sq2: Int => Int = x => x * x
  val addOne: Int => Int = _ + 1
  val weirdSum: (Int, Int) => Int = _ * 2 + _ * 3

  def foo(x: Int): Int = {
    val anonFunc: Int => Int = { z =>
      if (z > 5) return z
      else z + 2
    }
    anonFunc(x)
  }

  val r = 1 to 5

  def showNumbersInRange(a: Int, b: Int) {
    print(a)
    if(a < b)
      showNumbersInRange(a + 1, b)
  }

  val text = if(1 == 10) "yeah" else "nope"

  val a = Array(1, 2, 3, 5, 8, 13)
  val m = Map("fork" -> "tenedor", "spoon" -> "cuchara", "knife" -> "chuchillo")
  val safeM = m.withDefaultValue("no lo se")
  val s = Set(1, 3, 7)

  val mydog = Dog.createDog("greyhound")

  val george = Person("George", "1234")
  val kate = Person("Kate", "4567")

  val email = "(.*)#(.*)".r

  def matchEverything(obj: Any):String = obj match {
    case "Hello world" => "Got the string Hello world"
    case x: Double => "Got a Double: " + x
    case x: Int if x > 10000 => "Got a pretty big number"
    case Person(name, number) => s"Got contact info for $name"
    case email(name, domain) => s"Got email address $name@$domain"
    case (a: Int, b: Double, c: String) => s"Got a tuple: $a, $b, $c"
    case List(1, b, c) => s"Got a list with three elements and starts with 1: 1, $b, $c"
    case List(List((1, 2, "YAY"))) => "Got a list of list of tuple"
    case _ => "Got unknown object"
  }

  val patternFunc: Person => String = {
    case Person("George", number) => s"George's number: $number"
    case Person(name, number) => s"Random person's number: $number"
  }

  val add10: Int => Int = _ + 10
  val sSquared = s.map(sq)

  val nSquared = for { n <- s } yield sq(n)

  implicit val myImplicitInt = 100
  implicit def myImplicitFunction(breed: String) = new Dog("Golden " + breed)

  def sendGreetings(toWhom: String)(implicit howMany: Int) =
    s"Hello $toWhom, $howMany blessings to you and yours!"

  def main(args: Array[String]) = {
    println(sendGreetings("Fred"))
  }
}

class Dog(br: String) {
  var breed: String = br
  def bark = "Woof Woof"
  private def sleep(hours: Int) = println(s"I'm sleeping for $hours hours")
}

object Dog {
  def allKnownBreeds = List("pitbull", "shepherd", "retriever")
  def createDog(breed: String) = new Dog(breed)
}

case class Person(name: String, phoneNumber: String)