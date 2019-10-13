package domain.rules.shogiban

import domain.rules.koma._

object MoveKomaRules {

  def moveRange(koma: Koma): List[RelativePosition] = {
    def mkRPs(rps: (Int, Int)*): List[RelativePosition] = {
      rps
        .map({ case (rh, rv) => RelativePosition(RPosH(rh), RPosV(rv)) })
        .toList
    }
    koma match {
      case Hiyoko   => mkRPs((0, -1))
      case Kirin    => mkRPs((0, -1), (-1, 0), (1, 0), (0, 1))
      case Zou      => mkRPs((-1, -1), (1, -1), (-1, 1), (1, 1))
      case Raion    => mkRPs((-1, -1), (0, -1), (1, -1), (-1, 0), (1, 0), (-1, 1), (0, 1), (1, 1))
      case Niwatori => mkRPs((-1, -1), (0, -1), (1, -1), (-1, 0), (1, 0), (0, 1))
    }
  }

}
