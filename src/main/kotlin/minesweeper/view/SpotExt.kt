package minesweeper.view

import minesweeper.domain.spot.DefaultSpot
import minesweeper.domain.spot.MineSpot
import minesweeper.domain.spot.Spot

fun Spot.characterOf(): CharSequence {
    if (this.isRevealed && this is DefaultSpot) {
        return "${this.surroundMineCount}"
    }
    if (this.isRevealed &&  this is MineSpot) {
        return "*"
    }
    return "C"

}
