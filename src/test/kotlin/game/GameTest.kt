package game

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun testCreate() {
        val game = Game(
            "Magyarország",
            "Portugália",
            3,
            1
        )
        assertEquals("Magyarország", game.firstCountry)
        assertEquals("Portugália", game.secondCountry)
        assertEquals(3, game.firstCountryScore)
        assertEquals(1, game.secondCountryScore)
    }
}
