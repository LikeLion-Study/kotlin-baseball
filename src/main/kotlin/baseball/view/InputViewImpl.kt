package baseball.view

import baseball.BaseballContract

class InputViewImpl : BaseballContract.InputView {
    override fun readGuessedNumber(): String {
        print("숫자를 입력해주세요: ")
        return readln()
    }

    override fun readRestartingInput(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 잘못 입력하셨습니다. 다시 한 번 입력해 주세요.")
    }
}