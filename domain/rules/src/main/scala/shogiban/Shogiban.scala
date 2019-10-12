package domain.rules.shogiban

import domain.rules.koma.Koma

case class Shogiban(
    senteKomaSet: Set[Koma],
    goteKomaSet: Set[Koma]
)
