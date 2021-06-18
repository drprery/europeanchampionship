package game

class GameService(private var gameRepository: GameRepository) {

    fun getGameWithMostGoalDifference(): Game? {
        return gameRepository.getGames().maxByOrNull{ it -> Math.abs((it.firstCountryScore) - (it.secondCountryScore))}
    }

    fun getCountryWithMostGoals(): String {
        var result: HashMap<String, Int> = HashMap()
        var actual: Int = 0
        var maxBattle: Int = 0
        var country: String = "Nincs"

        for(game in gameRepository.getGames()) {
            if(!result.containsKey(game.firstCountry)) {
                result[game.firstCountry] = game.firstCountryScore
            } else {
                actual = result[game.firstCountry]!!
                result.replace(game.firstCountry, actual + game.firstCountryScore)
                if(actual > maxBattle) {
                    maxBattle = 2 * actual + game.firstCountryScore
                    country = game.firstCountry
                }
            }

            if(!result.containsKey(game.secondCountry)) {
                result[game.secondCountry] = game.secondCountryScore
            } else {
                actual = result[game.secondCountry]!!
                result.replace(game.secondCountry, actual + game.secondCountryScore)
                if(actual > maxBattle) {
                    maxBattle = 2 * actual + game.secondCountryScore
                    country = game.secondCountry
                }
            }
        }
        return country
    }

    fun getGoals(country: String): Int {
        var goals: Int = 0

        for(g in gameRepository.getGames()) {
            if(g.firstCountry == country) {
                goals += g.firstCountryScore
            } else if (g.secondCountry == country)  {
                goals += g.secondCountryScore
            }
        }
        return goals
    }
}