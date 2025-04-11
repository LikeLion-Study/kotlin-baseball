package baseball

import baseball.model.GuessNumber
import baseball.utils.constants.Error
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GuessNumberTest {

    @Test
    fun `사용자 입력을 올바르게 파싱했을 경우`() {
        val input = "123"

        val guess = GuessNumber.parse(input)

        assertThat(guess.number).isEqualTo(listOf(1, 2, 3))
    }

    @Test
    fun `입력이 숫자가 아닐 때 오류 발생`() {
        val input = "12a"

        val exception = assertThrows<IllegalArgumentException> {
            GuessNumber.parse(input)
        }

        assertEquals(Error.NOT_NUMBER, exception.message)
    }

    @Test
    fun `숫자가 3자리가 아닐 때 오류 발생`() {
        val input = "1234"

        val exception = assertThrows<IllegalArgumentException> {
            GuessNumber.parse(input)
        }

        assertEquals(Error.DIFFERENT_DIGITS, exception.message)
    }

    @Test
    fun `중복 숫자가 있을 때 오류 발생`() {
        val input = "111"

        val exception = assertThrows<IllegalArgumentException> {
            GuessNumber.parse(input)
        }

        assertEquals(Error.DUPLICATE_NUMBER, exception.message)
    }

    @Test
    fun `입력 값에 0이 있을 경우 오류 발생`() {
        val input = "012"

        val exception = assertThrows<IllegalArgumentException> {
            GuessNumber.parse(input)
        }

        assertEquals(Error.OUT_OF_RANGE_NUMBER, exception.message)
    }
}
