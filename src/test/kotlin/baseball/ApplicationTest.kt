package baseball

import baseball.model.RandomNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest {

    @Test
    fun `랜덤 숫자 생성 함수는 1부터 9까지의 숫자 3개를 생성한다`() {
        val numbers = RandomNumberGenerator.generate()

        assertThat(numbers.size).isEqualTo(3)

        numbers.forEach { number ->
            assertThat(number).isBetween(1, 9)
        }

        assertThat(numbers.distinct().size).isEqualTo(3)
    }
}