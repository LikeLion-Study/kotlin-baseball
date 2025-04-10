package baseball.presenter

import baseball.BaseballContract
import baseball.model.GameJudge
import baseball.model.GuessNumber
import baseball.model.RandomNumberGenerator
import baseball.utils.Const
import baseball.utils.retryInput

class BaseballPresenter(
    private val inputView: BaseballContract.InputView,
    private val outputView: BaseballContract.OutputView,
) : BaseballContract.Presenter {
    override fun execute() {
        outputView.printGamePlayMessage()
        playBaseball()
    }

    private fun playBaseball() {
        val judge = initialNumberSetting()
        proceedInning(judge)
        outputView.printGameWinningMessage()
        if (selectRestart()) playBaseball()
    }

    private fun initialNumberSetting(): GameJudge {
        val randomNumber = RandomNumberGenerator.generate()
        return GameJudge(randomNumber)
    }

    private fun proceedInning(judge: GameJudge) {
        return retryInput(
            runBlock = {
                do {
                    val inputNumber = inputView.readGuessedNumber()
                    val guess = GuessNumber.parse(inputNumber)
                    val (strike, ball) = judge.compare(guess.number)
                    outputView.printGuessedResultMessage(strike, ball)
                } while (strike != Const.MAX_NUMBER_COUNT)
            },
            onError = {
                outputView.printErrorMessage(it)
            }
        )
    }

    private fun selectRestart(): Boolean {
        while (true) {
            runCatching {
                val selected = inputView.readRestartingInput()
                return when (selected) {
                    "1" -> true
                    "2" -> false
                    else -> throw IllegalArgumentException ("")
                }
            }.onFailure {
                outputView.printErrorMessage(it.message)
            }
        }
    }
}