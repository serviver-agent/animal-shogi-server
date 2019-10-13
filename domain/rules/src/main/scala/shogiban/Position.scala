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
) {

  import Position._

  def move(rp: RelativePosition): Either[PositionError, Position] = {
    (h.move(rp.rh), v.move(rp.rv)) match {
      case (Some(h), Some(v)) => Right(Position(h, v))
      case _                  => Left(PositionError.OutOfShougiban)
    }
  }

}

object Position {

  trait PositionError
  object PositionError {
    case object OutOfShougiban extends PositionError
  }

}

sealed abstract class PosH(value: Int) {
  def move(rh: RPosH): Option[PosH] = {
    (this.value + rh.value) match {
      case 1 => Some(PosA)
      case 2 => Some(PosB)
      case 3 => Some(PosC)
      case _ => None
    }
  }
}
object PosA extends PosH(1)
object PosB extends PosH(2)
object PosC extends PosH(3)

sealed abstract class PosV(value: Int) {
  def move(rv: RPosV): Option[PosV] = {
    (this.value + rv.value) match {
      case 1 => Some(Pos1)
      case 2 => Some(Pos2)
      case 3 => Some(Pos3)
      case 4 => Some(Pos4)
      case _ => None
    }
  }
}
object Pos1 extends PosV(1)
object Pos2 extends PosV(2)
object Pos3 extends PosV(3)
object Pos4 extends PosV(4)

case class RelativePosition(
    rh: RPosH,
    rv: RPosV
) {
  def reverse = RelativePosition(RPosH(-1 * rv.value), RPosV(-1 * rh.value))
}
case class RPosH(value: Int)
case class RPosV(value: Int)
