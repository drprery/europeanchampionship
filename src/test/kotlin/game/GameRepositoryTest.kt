package game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameRepositoryTest {

    var gameRepository = GameRepository()

    @BeforeEach
    fun setUp() {

    }

    @Test
    fun testReadFromFile() {
        gameRepository.readFromFile("src/main/resources/results.csv")

        assertEquals("Wales", gameRepository.getGames()[1].firstCountry)
        assertEquals("Russia", gameRepository.getGames()[3].secondCountry)
        assertEquals(0, gameRepository.getGames()[7].firstCountryScore)
        assertEquals(1, gameRepository.getGames()[12].secondCountryScore)
    }

    @Test
    fun testAddGame() {
        assertEquals(0, gameRepository.getGames().size)
        gameRepository.addGame(Game("Magyarország", "Portugália", 3, 1))
        assertEquals(1, gameRepository.getGames().size)
        assertEquals("Magyarország", gameRepository.getGames()[0].firstCountry)
        assertEquals(3, gameRepository.getGames()[0].firstCountryScore)
    }
}