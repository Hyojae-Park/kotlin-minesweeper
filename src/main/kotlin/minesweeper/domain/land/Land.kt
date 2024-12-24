package minesweeper.domain.land

import minesweeper.domain.state.GameState
import minesweeper.domain.spot.DefaultSpot
import minesweeper.domain.spot.MineSpot
import minesweeper.domain.spot.Spot

class Land private constructor(val spots: List<Spot>, val land: LandSize) {
    // data class MinesMap(val landSize: LandSize, val mines: List<Int>)
    val mineMap = MinesMap(land,
        spots.filterIsInstance<MineSpot>().map {
            it.point.toIndex(land.width)
        })

    fun revealSpots(point : Point): GameState {
        // 지뢰가 없는 인접한 칸이 모두 열리게 된다. -> 주변에 지뢰가 없으면 주변 이 모두 열린다
        val index = point.toIndex(land.width)
        val spot = spots[index]
        spot.isRevealed = true
        if (spot is MineSpot) return GameState.Done
        if (spot.surroundMineCount == 0) {
            point.surroundIndexes(land).forEach {
                if (spots[it].isRevealed.not())
                    this@Land.revealSpots(it.toPoint(land.width))
            }
        }

        if (spots.count { it is DefaultSpot && !it.isRevealed } == 0) return GameState.Done

        return GameState.Doing
    }

    fun mines(): List<Spot> {
        return spots.filter { it is MineSpot }
    }

    fun getLines(y: Int): List<Spot> {
        val startIndex = y * land.width
        return spots.slice(startIndex..<(startIndex + land.width))
    }

    companion object {
        fun from(
            land: LandSize,
            mineCount: Int,
            generateMines: ((Int, Int) -> List<Int>),
        ): Land {
            val landSize = land.size()
            check(landSize > mineCount) { "땅보다 많은 지뢰를 심을 수 없어요" }

            val mines = generateMines.invoke(landSize, mineCount)
            val spots =
                List(landSize) { index ->
                    val point = index.toPoint(land.width)
                    mines.takeIf {
                        it.contains(index)
                    }?.let {
                        MineSpot(point)
                    } ?: DefaultSpot(point, MinesMap(land, mines))
                }

            return Land(spots, land)
        }
    }
}
