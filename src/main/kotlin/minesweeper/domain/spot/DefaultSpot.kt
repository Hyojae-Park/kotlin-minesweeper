package minesweeper.domain.spot

import minesweeper.domain.land.MinesMap
import minesweeper.domain.land.Point

class DefaultSpot(point: Point, mineData: MinesMap) : Spot(point) {
    override val surroundMineCount: Int = mineData.countMinesNearby(point)
}
