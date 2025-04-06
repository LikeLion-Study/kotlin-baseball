package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

class ApplicationTest {
    private val originalOut = System.out
    private lateinit var outputStream: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream, true, StandardCharsets.UTF_8.name()))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `게임 시작 및 초기 프롬프트 출력 테스트`() {
        main()

        val output = outputStream.toString(StandardCharsets.UTF_8.name())
        assertThat(output).contains("숫자 야구 게임을 시작합니다.")
        assertThat(output).contains("숫자를 입력해주세요")
    }

    @Test
    fun `승리 후 메시지 출력 테스트`() {
        main()

        val output = outputStream.toString(StandardCharsets.UTF_8.name())
        assertThat(output).contains("3스트라이크")
        assertThat(output).contains("3개의 숫자를 모두 맞히셨습니다!")
        assertThat(output).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

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