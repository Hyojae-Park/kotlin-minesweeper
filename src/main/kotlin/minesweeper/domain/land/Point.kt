package minesweeper.domain.land

data class Point(val x: Int, val y: Int) {
    companion object {
        fun indexToPoint(
            index: Int,
            width: Int,
        ) = Point(index % width, index / width)

        fun pointToIndex(
            point: Point,
            width: Int,
        ) = point.y * width + point.x
    }
}
