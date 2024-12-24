package minesweeper.view

import minesweeper.domain.land.Land
import minesweeper.domain.spot.Spot

object ResultView {
    fun startGame() {
        println("지뢰찾기 게임 시작")
    }

    fun showLand(land: Land) {
        val height = land.land.height
        for (n in 0..<height) {
            println(land.getLines(n).toShowString())
        }
    }
}

private fun List<Spot>.toShowString() =
    this.joinToString(
        separator = " ",
        transform = {
            it.characterOf()
        },
    )
