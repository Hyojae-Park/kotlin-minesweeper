package minesweeper.domain.spot

import minesweeper.domain.land.Point

abstract class Spot(val point: Point) {
    open val surroundMineCount = -1
    var isRevealed: Boolean = false
}
