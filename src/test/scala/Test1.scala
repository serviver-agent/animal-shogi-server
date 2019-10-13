import org.junit.Test
import org.junit.Assert._

class Test1 {
  @Test def t1(): Unit = {
    import hoge._
    import Day._
    assertEquals(Monday.isWeekend, false)
  }
}
