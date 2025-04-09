package baseball.view

import baseball.BaseballContract

class OutputViewImpl : BaseballContract.OutputView {
    override fun printGamePlayMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    override fun printGuessedResultMessage(ball: Int, strike: Int) {
        if (ball != 0) print("%d볼 ".format(ball))
        if (strike != 0) print("%d스트라이크".format(strike))
        println()
    }

    override fun printGameWinningMessage() {
        println("3개의 숫자를 모두 맞히셨습니다!")
    }

    override fun printErrorMessage(message: String?) {
        println(message)
    }
}