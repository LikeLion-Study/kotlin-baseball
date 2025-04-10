package baseball

interface BaseballContract {
    interface InputView {
        fun readGuessedNumber(): String
        fun readRestartingInput(): String
    }

    interface OutputView {
        fun printGamePlayMessage()
        fun printGuessedResultMessage(strike: Int, ball: Int)
        fun printGameWinningMessage()
        fun printErrorMessage(message: String?)
    }

    interface Presenter {
        fun execute()
    }
}