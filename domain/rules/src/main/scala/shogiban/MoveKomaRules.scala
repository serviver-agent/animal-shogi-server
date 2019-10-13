package domain.rules.shogiban

import domain.rules.koma.Koma
import domain.rules.koma.Koma._

object MoveKomaRules {

  def moveRelativePosition(koma: Koma): List[RelativePosition] = {
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

  def movableInShogiban(placedKoma: PlacedKoma, shogiban: Shogiban, player: Player): List[Position] = {

    val rps = moveRelativePosition(placedKoma.koma)
    val poss: List[Position] = rps.map(rp => placedKoma.position.move(rp)).collect {
      case Right(p) => p
    }
    val existPlayersKomaSet = shogiban.placedKomas.filter(_.player == player).map(_.position).toSet
    poss.filter(existPlayersKomaSet)

  }

}
