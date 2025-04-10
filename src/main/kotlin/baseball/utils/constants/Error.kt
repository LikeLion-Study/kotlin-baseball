package baseball.utils.constants

object Error {
    private const val ERROR = "[ERROR]"

    const val INCORRECT_INPUT = "$ERROR 잘못 입력하셨습니다. 다시 입력해 주세요."
    const val NOT_NUMBER = "$ERROR 문자가 입력되었습니다. 다시 입력해 주세요."
    const val DUPLICATE_NUMBER = "$ERROR 중복된 숫자가 입력되었습니다. 다시 입력해 주세요."
    const val OUT_OF_RANGE_NUMBER = "$ERROR 숫자 범위를 벗어났습니다. 다시 입력해 주세요."
}