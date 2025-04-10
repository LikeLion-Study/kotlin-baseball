package baseball.view

import baseball.BaseballContract

class InputViewImpl : BaseballContract.InputView {
    override fun readGuessedNumber(): String {
        print(INPUT_GUESS_NUMBER_MESSAGE)
        return readln()
    }

    override fun readRestartingInput(): String {
        println(INPUT_SELECT_RESTART_MESSAGE)
        return readln()
    }

    companion object {
        private const val INPUT_GUESS_NUMBER_MESSAGE = "숫자를 입력해주세요: "
        private const val INPUT_SELECT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
}