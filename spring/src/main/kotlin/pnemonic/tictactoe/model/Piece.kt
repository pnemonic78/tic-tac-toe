package pnemonic.tictactoe.model

enum class Piece(val rawValue: Char) {
    NONE('_'),
    X('X'),
    O('O');

    override fun toString(): String {
        return rawValue.toString()
    }
}