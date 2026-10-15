package pnemonic.tictactoe.control

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pnemonic.tictactoe.model.Player
import pnemonic.tictactoe.model.PlayerRequest
import pnemonic.tictactoe.service.PlayerService
import java.util.*

@RestController
@RequestMapping("/player")
class PlayerController(
    private val playerService: PlayerService,
) {
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun createPlayer(@RequestBody playerRequest: PlayerRequest): Player {
        logger.debug("Create player {}", playerRequest)
        val player = Player().apply {
            email = playerRequest.email
            name = playerRequest.name
        }
        return playerService.createPlayer(player)
    }

    @PutMapping("/{playerId}")
    fun updatePlayer(@PathVariable playerId: UUID, @RequestBody player: Player): Player {
        logger.debug("Update player {}", player)
        if (playerId == player.id) {
            return playerService.updatePlayer(player)
        }
        throw IllegalArgumentException("Player mismatch")
    }

    @GetMapping("/{playerId}")
    fun getPlayer(@PathVariable playerId: UUID): Player {
        logger.debug("Get player {}", playerId)
        return playerService.getPlayer(playerId)
    }

    @GetMapping("/list")
    fun getAllPlayers(): List<Player> {
        logger.debug("Getting all players")
        return playerService.getAllPlayers()
    }

    @DeleteMapping("/{playerId}")
    fun deletePlayer(@PathVariable playerId: UUID) {
        logger.debug("Delete player {}", playerId)
        return playerService.deletePlayer(playerId)
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(PlayerController::class.java)
    }
}