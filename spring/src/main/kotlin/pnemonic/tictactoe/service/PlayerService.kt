package pnemonic.tictactoe.service

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import pnemonic.tictactoe.model.Player
import pnemonic.tictactoe.repository.PlayerRepository
import java.util.*

@Service
class PlayerService(
    private val playerRepository: PlayerRepository,
) {
    fun createPlayer(player: Player): Player {
        return playerRepository.save(player)
    }

    fun updatePlayer(player: Player): Player {
        val playerDb = playerRepository.findById(player.id!!)
        if (playerDb.isPresent) {
            return playerRepository.save(player)
        }
        throw IllegalArgumentException("Player with id ${player.id} not found")
    }

    fun getPlayer(@PathVariable playerId: UUID): Player {
        return playerRepository.findById(playerId).get()
    }

    fun getAllPlayers(): List<Player> {
        return playerRepository.findAll()
    }

    fun deletePlayer(@PathVariable playerId: UUID) {
        return playerRepository.deleteById(playerId)
    }
}