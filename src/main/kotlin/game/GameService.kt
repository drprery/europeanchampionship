package game

import kotlin.math.abs

class GameService(private var gameRepository: GameRepository) {

    var result: HashMap<String, Int> = HashMap()
    var actual: Int = 0
    var maxBattle: Int = 0
    var country: String = "Nincs"

    fun getGameWithMostGoalDifference(): Game? {
        return gameRepository.getGames().maxByOrNull { abs((it.firstCountryScore) - (it.secondCountryScore)) }
    }

    fun getCountryWithMostGoals(): String {
        actual = 0
        maxBattle = 0
        country = "Nincs"

        for (game in gameRepository.getGames()) {
            resultUpdate(game.firstCountry, game.firstCountryScore)
            resultUpdate(game.secondCountry, game.secondCountryScore)
        }
        return country
    }

    fun getGoals(country: String): Int {
        var goals: Int = 0

        for (g in gameRepository.getGames()) {
            if (g.firstCountry == country) {
                goals += g.firstCountryScore
            } else if (g.secondCountry == country) {
                goals += g.secondCountryScore
            }
        }
        return goals
    }

    fun getGameRepository(): GameRepository {
        return gameRepository
    }

    private fun resultUpdate(key: String, value: Int) {
        if (!result.containsKey(key)) {
            result[key] = value
        } else {
            actual = result[key]!!
            result.replace(key, actual + value)
            if (actual > maxBattle) {
                maxBattle = 2 * actual + value
                country = key
            }
        }
    }
}