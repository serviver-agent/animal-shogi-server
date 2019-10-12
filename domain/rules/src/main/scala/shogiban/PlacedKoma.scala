package domain.rules.shogiban

import domain.rules.koma.Koma

case class PlacedKomaId(value: Int)
case class PlacedKoma(
  id: PlacedKomaId,
  player: Player,
  position: Position,
  koma: Koma
)
