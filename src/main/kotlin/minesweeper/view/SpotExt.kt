package minesweeper.view

import minesweeper.domain.spot.DefaultSpot
import minesweeper.domain.spot.Spot

fun Spot.characterOf(): CharSequence {
    if (this is DefaultSpot)
        return this.surroundMineCount.toString()
    return "*"
}
