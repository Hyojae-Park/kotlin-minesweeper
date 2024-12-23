package minesweeper.domain.land

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class MinesMapTest {
    @Test
    fun `주변의 지뢰 갯수 1`() {
        val landSize = LandSize(10, 10)
        val mines = (1..6).toList()
        val mineData = MinesMap(landSize, mines)
        val point1 = Point(0, 0)
        mineData.countMinesNearby(point1) shouldBe 1
    }

    @Test
    fun `주변의 지뢰 갯수 2`() {
        val landSize = LandSize(10, 10)
        val mines = (1..6).toList()
        val mineData = MinesMap(landSize, mines)
        val point3 = Point(1, 1)
        mineData.countMinesNearby(point3) shouldBe 2
    }

    @Test
    fun `주변의 지뢰 갯수 0`() {
        val landSize = LandSize(10, 10)
        val mines = (1..6).toList()
        val mineData = MinesMap(landSize, mines)
        val point5 = Point(8, 9)
        mineData.countMinesNearby(point5) shouldBe 0
    }

    @Test
    fun `주변의 지뢰 갯수 3`() {
        val landSize = LandSize(10, 10)
        val mines = (1..6).toList()
        val mineData = MinesMap(landSize, mines)
        val point5 = Point(2, 1)
        mineData.countMinesNearby(point5) shouldBe 3
    }
}
