package minesweeper.domain.spot

import minesweeper.domain.land.MinesMap
import minesweeper.domain.land.Point

class DefaultSpot(point: Point, mineData: MinesMap) : Spot(point) {
    val surroundMineCount: Int = mineData.countMinesNearby(point)
}
