// To add functionality to an existing object,
// create an Implicit class

// Add a method to String to allow each character to be
// incremented by one char

implicit class StringImprovements(s : String) {
  def increment = s.map( c=> (c+1).toChar)
}


"HAL".increment

// Although this works in a worksheet, in actual scala code, implicit
// classes can't be top-level, so must be define in an enclosing class,
// object or package object

// *** Object ****

//package my.package
//object StringUtils {
//  implicit class StringImprovements(s : String) {
//    def increment = s.map( c=> (c+1).toChar)
//  }
//
//}

// Then elsewhere

//package an.other
//
//import my,package,StringUtils._
//object Main extends App {
//  println("HAL".increment)
//}


// **** Package objects ****

