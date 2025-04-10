package baseball.model

import baseball.utils.Const

class GuessNumber private constructor(val number: List<Int>) {
    companion object {
        private const val OUT_OF_RANGE_NUMBER = "0"

        fun parse(input: String): GuessNumber {
            require(input.toIntOrNull() != null) { "" }
            require(input.toSet().size == Const.MAX_NUMBER_COUNT) { "" }
            require(!input.contains(OUT_OF_RANGE_NUMBER)) { "" }

            return GuessNumber(input.map { it.digitToInt() })
        }
    }
}