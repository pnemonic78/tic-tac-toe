package pnemonic.tictactoe.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.util.UUID

@Entity
@Table(name = "player")
class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    @Email
    var email: String = ""

    @NotBlank
    var name: String = ""

    @Min(0L)
    var score: Long = 0L
}
