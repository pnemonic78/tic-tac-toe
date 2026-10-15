package pnemonic.tictactoe.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class PlayerRequest(
    @Email
    val email: String,
    @NotBlank
    val name: String,
)
