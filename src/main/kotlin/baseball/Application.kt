package baseball

import baseball.presenter.BaseballPresenter
import baseball.view.InputViewImpl
import baseball.view.OutputViewImpl

fun main() {
    val inputView: BaseballContract.InputView = InputViewImpl()
    val outputView: BaseballContract.OutputView = OutputViewImpl()
    val baseball = BaseballPresenter(inputView, outputView)
    baseball.execute()
}