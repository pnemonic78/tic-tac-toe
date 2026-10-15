package pnemonic.tictactoe.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pnemonic.tictactoe.model.Game
import java.util.UUID

@Repository
interface GameRepository : JpaRepository<Game, UUID> {
}