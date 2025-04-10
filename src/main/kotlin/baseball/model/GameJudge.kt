package baseball.model

class GameJudge(private val correctNumber: List<Int>) {

    fun compare(guessNumber: List<Int>): Pair<Int, Int> {
        val matchingStrike = containsStrike(guessNumber)
        val matchingBall = containsBall(guessNumber)
        return matchingStrike to matchingBall
    }

    private fun containsStrike(guessNumber: List<Int>): Int {
        return correctNumber.indices.count { correctNumber[it] == guessNumber[it] }
    }

    private fun containsBall(guessNumber: List<Int>): Int {
        return correctNumber
            .indices
            .count { correctNumber[it] != guessNumber[it] && correctNumber.containsAll(guessNumber) }
    }
}