package baseball.model

class GuessNumber private constructor(private val number: List<Int>) {
    companion object {
        fun parse(input: String): GuessNumber {
            require(input.toIntOrNull() != null) { "" }
            require(input.toSet().size == 3) { "" }
            require(!input.contains("0")) { "" }

            return GuessNumber(input.map { it.digitToInt() })
        }
    }
}