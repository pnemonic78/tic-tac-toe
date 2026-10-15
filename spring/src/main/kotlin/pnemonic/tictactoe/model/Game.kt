package pnemonic.tictactoe.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "game")
class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "player1_id",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "FK_GAME_PLAYER1")
    )
    var player1: Player? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "player2_id",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "FK_GAME_PLAYER2")
    )
    var player2: Player? = null

    var started: Long = Long.MAX_VALUE
    var ended: Long = Long.MAX_VALUE
    @Column(name = "player_turn")
    var playerTurn: Int = 0
    var board: List<Piece> = emptyList()

    companion object {
        const val ROWS = 3
        const val COLUMNS = 3
    }
}
