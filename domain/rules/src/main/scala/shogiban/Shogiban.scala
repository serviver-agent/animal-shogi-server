package domain.rules.shogiban

import domain.rules.koma.Koma

case class Shogiban(
  placedKomas: Seq[PlacedKoma]
)

object Shogiban {

  def initial: Shogiban = {
    import domain.rules.koma._

    val placedKomas = Seq(
      PlacedKoma(Gote,  Position(PosA, Pos1), Kirin),
      PlacedKoma(Gote,  Position(PosB, Pos1), Raion),
      PlacedKoma(Gote,  Position(PosC, Pos1), Zou),
      PlacedKoma(Gote,  Position(PosB, Pos2), Hiyoko),
      PlacedKoma(Sente, Position(PosB, Pos3), Hiyoko),
      PlacedKoma(Sente, Position(PosA, Pos4), Zou),
      PlacedKoma(Sente, Position(PosB, Pos4), Raion),
      PlacedKoma(Sente, Position(PosC, Pos4), Kirin),
    )
    Shogiban(placedKomas)
  }

}
