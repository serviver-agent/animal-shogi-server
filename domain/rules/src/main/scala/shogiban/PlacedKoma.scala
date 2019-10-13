package domain.rules.shogiban

import domain.rules.koma.Koma

case class PlacedKoma(
    player: Player,
    position: Position,
    koma: Koma
)
