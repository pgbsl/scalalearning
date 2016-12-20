import scala.util.Random

// Control structures

// If statements can return values - no need for Java ternary operator
val ifVal = if ( true) "true" else "false"

val rand = new Random(100)


// For loops - incorporate multiple nested depths into 1 loop
for {
  rowNumber <- 1 to 10
  columnNumber <- 1 to 5
  if rand.nextInt(10) < 5
} yield "[" + rowNumber + ", " + columnNumber + "]"


// 3.1 Looping with for and foreach

// Basic syntax

val a = Array ("Apples", "Oranges", "Bananas")
for (e <- a) println(e)

// returning values from loop
val newArray = for (e <- a) yield e.toUpperCase

// loop counters
for (i <- 0 until a.length) println(s"$i is ${a(i)}")

// collections offer a zipWithIndex, which creates a tuple of value and index
for ((item, index) <- a.zipWithIndex) println(s"$index is $item")

// Ranges
for (i <- 1 to 3) println(i)

// 1 to 3 is actually a range obect
1 to 3  // Generates Range(1, 2, 3)

// Guards can be used inside loops  (more on this later)
for (i <- 1 to 100 if i < 10 ) println(i)

// Looping over a map - make use of tuples
val namesMap = Map("fname" -> "Robert", "lname" -> "Gordon")
for ((key, value) <- namesMap) println(s"key - $key; value - $value")

// foreach - execute a function against each element
a.foreach(println)
// Use anonymouse function syntax if you need to refer to element inside function
a.foreach(e => println(e.toUpperCase))


// 3.2 For loops with multiple counters

for {
  rowNumber <- 1 to 4
  columnNumber <- 1 to 3
} println(s"** $rowNumber / $columnNumber")


// 3.3 Embedded guards

// Can use many guards inside a loop.  e.g. a (convoluted) way to print 4

for {
  i <- 1 to 10
  if i > 3
  if i< 6
  if i % 2 == 0
} println(i)

// 3.4 "for comprehension" (for/yield combination)
// Creates a new collection from a given input collection
// Simple for comprehension is very similar to the map function, which is neater

for (e <-a) yield e.toUpperCase
a.map(_.toUpperCase)


// 3.8 Matching multiple conditions
val i = 3
i match {
  case 1 | 3 | 5 => println("Odd")
  case 2 | 4 | 6 => println("Even")
  case defaultVariableName => println("Number not between 1 and 6")
    // Wildcard '_' can also be used for default case, but then you have no access to the value
}

// 3.11 Pattern matching
case class Person(name:String)

def echoWhatYouGaveMe(x : Any) : String = x match {
    // constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "you said hello"
    case Nil => "an empty list"

    // Sequence patterns
    case List(0, _, _) => "a three element list with 0 as 1st element"
    case List(1, _*) => "a list beginning with 1"
    case Vector(1, _*) => "a vector starting with 1"

    // tuples
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a and $b and $c"

    // Constructor patterns
    case Person(name) => s"Found a Person with $name"
    case p @ Person("Bob") => s"Found a Bob - and I have the variable to prove it $p"

    //typed patterns
    case s: String => s"You said $s"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"

    case _ =>

}