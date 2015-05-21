// String (Object) equality ==

val s1 = "hello"

val s2 = "hello"

s1 == s2

// Strings are collections

s1.foreach(println)
s1.drop(3).take(2).capitalize
// Multi line strings
val s3 = """This is a
  multiline string"""
// The above has whitespace, but if this was just code indentation, use
val s4 = """This is a
  |multiline string""".stripMargin
// strip margin above strips up to and including the '|' (pass a paramater and you can use a different separator

val s5 = """Multi "line" strings can
  |'contain' quotes and double
  | quotes""".stripMargin

// String interpolation (substitution)
val name = "Fred"
val age = 33
println(s"$name is $age years old")
// The 's' at the start of the string instructs the interpolation
// Arbitrary expression injection
println(s"If your are $age this year, then you will be ${age + 1} next year")
// s is a method.  This means that othet interpolation functions are possible, such as printf-style format
val weight = 20.926
println(f"This variable has been rounded $weight%.2f ")
// raw interpolator - don't escape any characters
var escaped = "This\nis\non 3 lines"
var nonescaped = raw"This\nis\non 3 lines"
// You can create your own interpolation functions
// MAP on a string
val upper = "hello world" map (c => c.toUpper)
// or using '_'
val upper2 = "hello world" map (_.toUpper)
// chaining - remove all "l" chars then to upper
val ls_Removed = "hello world" filter (_ != 'l') map (_.toUpper)
// The above could also be written as a for/yield loop
val verbose_for = for {
  c <- "hello world"
  if c != 'l'
} yield c.toUpper

// RegEx

// Use .r

val numPattern = "[0-9]+".r
val searchString = "I live at 826 main street, flat 78"

val firstMatch = numPattern.findFirstIn(searchString)
// Returns an Option with the first match

val allMatched = numPattern.findAllIn(searchString)
allMatched.foreach(println)

val noMatches = numPattern.findAllIn("hello")
// returns an empty iterator
noMatches.toArray
noMatches.toList
// etc

// ".r" is easy way to create a reg exp on a string, but maybe not very obvious
// More explicit...
import scala.util.matching.Regex
val explicitNumPattern = new Regex("[0-9]+")
explicitNumPattern.findFirstIn("10 is the 1st number")

// Using the option type to iterate

numPattern.findFirstIn("10 is the 1st number").foreach {
  e=> println(e)
}

numPattern.findAllIn("10 is the 1st number").foreach {
  e=> println(e)
}

numPattern.findFirstIn("10 is the 1st number") match {
  case Some(str) => println(s"Found: $str")
  case None => println("No matches")
}

numPattern.findFirstIn("There are no numbers") match {
  case Some(str) => println(s"Found: $str")
  case None => println("No matches")
}


// Replacing patterns in strings
val address = "123 Main st.".replaceAll("[0-9]", "x")

// or using a reg ex as the objects

"[0-9]".r.replaceFirstIn("123 Main St", "Y")

// Extract reg ex groups

val pattern = "([0-9]+) ([A-Za-z]+)".r
val pattern(count, fruit) = "100 Bananas"