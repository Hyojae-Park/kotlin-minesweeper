package minesweeper.domain.land

data class MinesMap(val landSize: LandSize, val mines: List<Int>) {
    fun countMinesNearby(point: Point): Int {
        return point.surroundIndexes(landSize).count {
            mines.contains(it)
        }
    }
}
