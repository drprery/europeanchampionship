package game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


internal class GameServiceTest {
    var gameService = GameService(GameRepository())

    @BeforeEach
    fun setup() {
        //gameService.getGameRepository().readFromFile("src/main/resources/results.csv")
        val gameRepository = GameRepository()
        gameRepository.addGame(Game("Hungary", "Portugal", 1, 0))
        gameRepository.addGame(Game("Denmark", "Finnland", 0, 1))
        gameRepository.addGame(Game("Wales", "Switzerland", 1, 1))
        gameRepository.addGame(Game("Turkey", "Wales", 1, 1))
        gameRepository.addGame(Game("Turkey", "Italy", 0, 3))
        gameRepository.addGame(Game("Spain", "Sweden", 0, 0))
        gameService = GameService(gameRepository)
    }

    @Test
    fun testGetGameWithMostGoalDifference() {
        assertEquals("Turkey", gameService.getGameWithMostGoalDifference()?.firstCountry)
        assertEquals("Italy", gameService.getGameWithMostGoalDifference()?.secondCountry)
    }

    @Test
    fun testGetCountryWithMostGoals() {
        assertEquals("Wales", gameService.getCountryWithMostGoals())
    }
}