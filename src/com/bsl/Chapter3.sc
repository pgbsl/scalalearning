import scala.util.Random

// Control structures

// If statements can return values


val ifVal = if ( true) "true" else "false"

val rand = new Random(100)
// For loops - incorporate multiple nested depths into 1 loop
for {
  rowNumber <- 1 to 10
  columnNumber <- 1 to 5
  if rand.nextInt(10) < 5
} yield "[" + rowNumber + ", " + columnNumber + "]"

