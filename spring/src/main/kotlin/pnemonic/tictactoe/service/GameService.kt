package pnemonic.tictactoe.service

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import pnemonic.tictactoe.model.Game
import pnemonic.tictactoe.repository.GameRepository
import java.util.*

@Service
class GameService(
    private val gameRepository: GameRepository,
) {
    fun createGame(game: Game): Game {
        return gameRepository.save(game)
    }

    fun updateGame(game: Game): Game {
        val gameDb = gameRepository.findById(game.id!!)
        if (gameDb.isPresent) {
            return gameRepository.save(game)
        }
        throw IllegalArgumentException("Game with id ${game.id} not found")
    }

    fun getGame(@PathVariable gameId: UUID): Game {
        return gameRepository.findById(gameId).get()
    }

    fun getAllGames(): List<Game> {
        return gameRepository.findAll()
    }

    fun deleteGame(@PathVariable gameId: UUID) {
        return gameRepository.deleteById(gameId)
    }
}