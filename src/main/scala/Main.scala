object hoge {
  enum Day {
    case Monday, Tuesday, Wednesdey, Thursday, Friday, Saturday, Sunday
    def isWeekend: Boolean = this match
      case Saturday | Sunday => true
      case _ => false
  }
  
  given: scala.util.FromString[Day] {
    def fromString(str: String): Day =
      try Day.valueOf(str)
      catch
        case _: IllegalArgumentException =>
          throw new IllegalArgumentException(s"$str is not a valid day")
  }
  
  def test(day: Day) =
    if day.isWeekend then
      println("Today is a weekend")
      println("I will rest")
    else
      println("Today is a workday")
      println("I will work")
  
}

object Main extends App {

  import hoge._
  import Day._
  test(Monday)

  println(Monday.isWeekend)

}
