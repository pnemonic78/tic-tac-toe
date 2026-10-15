package pnemonic.tictactoe.control

import org.slf4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.slf4j.LoggerFactory
import pnemonic.tictactoe.model.Game
import pnemonic.tictactoe.service.GameService
import java.util.*

@RestController
@RequestMapping("/game")
class GameController(
    private val gameService: GameService,
) {
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun createGame(@RequestBody game: Game): Game {
        logger.debug("Create game {}", game)
        return gameService.createGame(game)
    }

    @PutMapping("/{gameId}")
    fun updateGame(@PathVariable gameId: UUID, @RequestBody game: Game): Game {
        logger.debug("Update game {}", game)
        if (gameId == game.id) {
            return gameService.updateGame(game)
        }
        throw IllegalArgumentException("Game mismatch")
    }

    @GetMapping("/{gameId}")
    fun getGame(@PathVariable gameId: UUID): Game {
        logger.debug("Get game {}", gameId)
        return gameService.getGame(gameId)
    }

    @GetMapping("/list")
    fun getAllGames(): List<Game> {
        logger.debug("Getting all games")
        return gameService.getAllGames()
    }

    @DeleteMapping("/{gameId}")
    fun deleteGame(@PathVariable gameId: UUID) {
        logger.debug("Delete game {}", gameId)
        return gameService.deleteGame(gameId)
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(GameController::class.java)
    }
}