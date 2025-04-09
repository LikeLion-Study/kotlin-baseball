package baseball

interface BaseballContract {
    interface InputView {
        fun readGuessedNumber(): String
        fun readRestartingInput(): Int
    }

    interface OutputView {
        fun printGamePlayMessage()
        fun printGuessedResultMessage(ball: Int, strike: Int)
        fun printGameWinningMessage()
        fun printErrorMessage(message: String?)
    }

    interface Presenter {
        fun play()
    }
}