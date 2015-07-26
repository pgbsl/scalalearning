"100".toInt
"20.5".toDouble


// Scala does not hace checked exceptions, so exceptions such
// as NumberFormatException are unchecked.

// It is however good practice (and required if calling from java)
// to @throws annotate

@throws(classOf[NumberFormatException])
def toInt(s : String): Unit = {
  s.toInt
}

// Or in a more Scala friendly way

def toInt2(s : String) = {
  try (
    Some(s.toInt)
    ) catch {
    case e: NumberFormatException => None
  }
}

// All numberic tyes have toXXX methods to convert between different numeric types
// no need to cast

val a = 10
a.toChar
a.toByte
a.toDouble
val b = 100000000000000L
b.isValidLong
b.isValidInt // Too long to be a valid int

// Override numeric types

val anInt = 11
val aDouble = 11d
val aFloat = 1f
val aLong = 1l
// ... or annotate with type
val aByte = 1 : Byte
val anotherLong = 1 : Long
// ... or the type after the var name (this is more common)
val anotherDouble : Double = 1

// Hex

val aHexVal = 0x10
val aHexValStoredAsLong = 0xdel
// Type ascription (e.g. uppcasting from String to Object)
val s = "Dave"
val sAsObj : Object = s
// Replacements for ++ and --

// Use +=, *=, -=. /= etc (similar to java)



// Large numbers

scala.math.BigDecimal(1999999.182)
scala.math.BigInt(1879798798798l)
// These methods (unline java equivs) support numeric operators

val bigIntVal = BigInt(1)

bigIntVal + bigIntVal

// They are also mutable (unlike java, so += will actually change the value)



// Random Numbers
val seed = 100
val rand = new scala.util.Random(seed)
rand.nextInt(10)  // Number between 0 and 9
// Range between zero and a randon number less than 20

var range = 0 to rand.nextInt(20)

// Add for/yield to modify the numbers
for (i <- 0 to rand.nextInt(5)) yield i * 3

// Or a sequence of known length, filled with random nums
for (i <- 0 to 10) yield rand.nextInt(100)

// The 'to' above is actually a method on the int class
val r = 5 to 10

val r2 = 5 to 50 by 5  // Increment by 5 each time
val rwithUntil = 5 until 10
val rangeAsArray = 1 to 5 toArray
val rangeAsList = (1 to 5).toList
// NUmber formatting
val pi = 3.141592653
val piFormattedTo5dp = f"$pi%1.5f"
//println("hello")

java.text.NumberFormat.getIntegerInstance.format(100000)

java.text.NumberFormat.getCurrencyInstance.format(50.00)