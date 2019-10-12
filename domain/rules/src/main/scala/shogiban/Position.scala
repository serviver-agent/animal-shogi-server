package domain.rules.shogiban

/*
A B C
     1
     2
     3
     4
*/

case class Position(
  h: PosH,
  v: PosV
)

sealed abstract class PosH(value: Int)
object PosA extends PosH(1)
object PosB extends PosH(2)
object PosC extends PosH(3)

sealed abstract class PosV(value: Int)
object Pos1 extends PosV(1)
object Pos2 extends PosV(2)
object Pos3 extends PosV(3)
object Pos4 extends PosV(4)
