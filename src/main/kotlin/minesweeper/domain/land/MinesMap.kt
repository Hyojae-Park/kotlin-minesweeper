package minesweeper.domain.land

data class MinesMap(val landSize: LandSize, val mines: List<Int>) {
    fun countMinesNearby(point: Point): Int {
        val yRange = upperSpot(point.y)..lowerSpot(point.y)
        val xRange = leftSpot(point.x)..rightSpot(point.x)

        val surroundIndexes =
            yRange.flatMap { y ->
                xRange.map {
                        x ->
                    (y * landSize.width + x)
                }
            }

        return surroundIndexes.count {
            mines.contains(it)
        }
    }

    private fun leftSpot(x: Int): Int {
        return x.dec().coerceAtLeast(0)
    }

    private fun rightSpot(x: Int): Int {
        return x.inc().coerceAtMost(landSize.width - 1)
    }

    private fun upperSpot(y: Int): Int {
        return y.dec().coerceAtLeast(0)
    }

    private fun lowerSpot(y: Int): Int {
        return y.inc().coerceAtMost(landSize.height - 1)
    }
}
