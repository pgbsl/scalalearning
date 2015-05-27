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


// Recipe 2.3.....