package baseball.model

import baseball.utils.constants.Error
import baseball.utils.constants.General

class GuessNumber private constructor(val number: List<Int>) {
    companion object {
        private const val OUT_OF_RANGE_NUMBER = "0"

        fun parse(input: String): GuessNumber {
            require(input.toIntOrNull() != null) { Error.NOT_NUMBER }
            require(input.toSet().size == General.MAX_NUMBER_COUNT) { Error.DUPLICATE_NUMBER }
            require(!input.contains(OUT_OF_RANGE_NUMBER)) { Error.OUT_OF_RANGE_NUMBER }

            return GuessNumber(input.map { it.digitToInt() })
        }
    }
}