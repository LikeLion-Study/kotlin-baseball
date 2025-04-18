package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

class ApplicationTest {

    // TODO: 클래스명과 함수명 변경 가능 (RandomNumberGenerator.generate())
    @Test
    fun `랜덤 숫자 생성 함수는 1부터 9까지의 숫자 3개를 생성한다`() {

        // TODO: 랜덤 숫자 생성 함수가 int형 3자리 리스트를 반환하도록 구현

        val numbers = emptyList<Int>()  // 테스트 실행을 위한 임시 코드입니다. 구현 후 아래 코드처럼 변경해주세요.
//        val numbers = RandomNumberGenerator.generate()

        assertThat(numbers.size).isEqualTo(3)

        numbers.forEach { number ->
            assertThat(number).isBetween(1, 9)
        }

        assertThat(numbers.distinct().size).isEqualTo(3)
    }

    // TODO: 추가 코드 작성 가능
}
