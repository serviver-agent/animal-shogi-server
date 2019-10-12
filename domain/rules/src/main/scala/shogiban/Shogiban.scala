package domain.rules.shogiban

import domain.rules.koma.Koma

case class Shogiban(
  placedKomas: Seq[PlacedKoma]
)

object Shogiban {

  def initial: Shogiban = {
    import domain.rules.koma._

    val placedKomas = Seq(
      PlacedKoma(PlacedKomaId(1), Gote,  Position(PosA, Pos1), Kirin),
      PlacedKoma(PlacedKomaId(2), Gote,  Position(PosB, Pos1), Raion),
      PlacedKoma(PlacedKomaId(3), Gote,  Position(PosC, Pos1), Zou),
      PlacedKoma(PlacedKomaId(4), Gote,  Position(PosB, Pos2), Hiyoko),
      PlacedKoma(PlacedKomaId(5), Sente, Position(PosB, Pos3), Hiyoko),
      PlacedKoma(PlacedKomaId(6), Sente, Position(PosA, Pos4), Zou),
      PlacedKoma(PlacedKomaId(7), Sente, Position(PosB, Pos4), Raion),
      PlacedKoma(PlacedKomaId(8), Sente, Position(PosC, Pos4), Kirin),
    )
    Shogiban(placedKomas)
  }

}
