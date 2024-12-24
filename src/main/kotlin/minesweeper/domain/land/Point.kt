package minesweeper.domain.land

data class Point(val x: Int, val y: Int) {

    fun surroundIndexes(size: LandSize): List<Int> {
        val yRange = upperSpot(y)..lowerSpot(y, size.height)
        val xRange = leftSpot(x)..rightSpot(x, size.width)

        val surroundIndexes =
            yRange.flatMap { y ->
                xRange.map {
                        x ->
                    (y * size.width + x)
                }
            }

        return surroundIndexes
    }

    private fun leftSpot(x: Int): Int {
        return x.dec().coerceAtLeast(0)
    }

    private fun rightSpot(x: Int, width: Int): Int {
        return x.inc().coerceAtMost(width -1)
    }

    private fun upperSpot(y: Int): Int {
        return y.dec().coerceAtLeast(0)
    }

    private fun lowerSpot(y: Int, height: Int): Int {
        return y.inc().coerceAtMost(height - 1)
    }
}

fun Int.toPoint(width: Int) = Point(this % width, this / width)
fun Point.toIndex(width: Int) = this.y * width + this.x
