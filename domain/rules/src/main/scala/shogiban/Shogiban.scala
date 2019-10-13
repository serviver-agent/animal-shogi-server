package domain.rules.shogiban

import domain.rules.koma.Koma
import domain.rules.koma.Koma._

case class Shogiban(
    placedKomas: Seq[PlacedKoma],
    stockingKomas: Seq[StockingKoma]
) {

  import Shogiban._

  def moveKoma(from: Position, to: Position): Either[MoveKomaError, Shogiban] = {
    import Shogiban.util._

    def pick(from: Position) = placedKomas.find(_.position == from).noneToLeft(MoveKomaError.KomaNotFound)

    def move(koma: PlacedKoma, to: Position): Either[MoveKomaError, PlacedKoma] = ???

    for {
      picked <- pick(from)
      moved  <- move(picked, to)
    } yield Shogiban(this.placedKomas.filter(_ != picked).appended(moved), this.stockingKomas)
  }

}

object Shogiban {

  def initial: Shogiban = {
    import domain.rules.koma._

    val placedKomas = Seq(
      PlacedKoma(Gote, Position(PosA, Pos1), Kirin),
      PlacedKoma(Gote, Position(PosB, Pos1), Raion),
      PlacedKoma(Gote, Position(PosC, Pos1), Zou),
      PlacedKoma(Gote, Position(PosB, Pos2), Hiyoko),
      PlacedKoma(Sente, Position(PosB, Pos3), Hiyoko),
      PlacedKoma(Sente, Position(PosA, Pos4), Zou),
      PlacedKoma(Sente, Position(PosB, Pos4), Raion),
      PlacedKoma(Sente, Position(PosC, Pos4), Kirin)
    )
    Shogiban(placedKomas, Nil)
  }

  trait MoveKomaError
  object MoveKomaError {
    case object KomaNotFound    extends MoveKomaError
    case object IllegalKomaMove extends MoveKomaError
  }

  object util {
    implicit class MyOption[T](opt: Option[T]) {
      def noneToLeft[A](left: A): Either[A, T] = opt match {
        case None    => Left(left)
        case Some(s) => Right(s)
      }
    }
  }

}
