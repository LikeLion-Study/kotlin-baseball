package baseball.view

import baseball.BaseballContract

class OutputViewImpl : BaseballContract.OutputView {
    override fun printGamePlayMessage() {
        println(GAME_PLAY_MESSAGE)
        println()
    }

    override fun printGuessedResultMessage(strike: Int, ball: Int) {
        if (ball != NONE_COUNT) print(BALL_COUNT.format(ball))
        if (strike != NONE_COUNT) print(STRIKE_COUNT.format(strike))
        if (strike + ball == NONE_COUNT) print(NOTING)
        println()
    }

    override fun printGameWinningMessage() {
        println()
        println(GAME_WINNING_MESSAGE)
    }

    override fun printErrorMessage(message: String?) {
        println(message)
    }

    companion object {
        private const val GAME_PLAY_MESSAGE = "숫자 야구 게임을 시작합니다."
        private const val GAME_WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!"

        private const val BALL_COUNT = "%d볼 "
        private const val STRIKE_COUNT = "%d스트라이크"
        private const val NOTING = "미스"

        private const val NONE_COUNT = 0
    }
}