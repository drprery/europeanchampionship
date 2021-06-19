package game

import java.io.File

class GameRepository {
    private var games: MutableList<Game> = ArrayList()

    fun getGames(): List<Game> {
        return ArrayList<Game>(games)
    }

    fun addGame(game: Game) {
        games += game
    }

    fun readFromFile(fileName: String) {
        var resultLine: List<String>
        var file = File(fileName)

        if (!file.exists()) {
            println("File doesn't exists!")
            return
        }
        val resultLines: List<String> = file.bufferedReader().readLines()
        for (gameLine in resultLines) {
            resultLine = gameLine.split(";")
            addGame(Game(resultLine[0], resultLine[1], resultLine[2].toInt(), resultLine[3].toInt()))
        }
    }

}