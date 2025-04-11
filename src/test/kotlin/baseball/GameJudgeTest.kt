package baseball

import baseball.model.GameJudge
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class GameJudgeTest {
    private val correctNumber = listOf(1, 2, 3)
    private val judge = GameJudge(correctNumber)

    companion object {
        @JvmStatic
        fun strikeListProvider(): Stream<Pair<List<Int>, Int>> = Stream.of(
            listOf(1, 4, 5) to 1, listOf(4, 2, 5) to 1, listOf(4, 5 ,3) to 1,
            listOf(1, 2, 4) to 2, listOf(4, 2, 3) to 2, listOf(1, 4, 3) to 2,
            listOf(1, 2, 3) to 3, listOf(4, 5, 6) to 0
        )

        @JvmStatic
        fun ballListProvider(): Stream<Pair<List<Int>, Int>> = Stream.of(
            listOf(4, 1, 5) to 1, listOf(4, 5, 1) to 1, listOf(2, 4, 5) to 1,
            listOf(4, 5, 2) to 1, listOf(3, 4, 5) to 1, listOf(4, 3, 5) to 1,
            listOf(2, 1, 4) to 2, listOf(3, 4, 1) to 2, listOf(4, 3, 2) to 2,
            listOf(2, 3, 1) to 3, listOf(4, 5, 6) to 0
        )
    }

    @ParameterizedTest
    @MethodSource("strikeListProvider")
    fun `심판은 각 자리수마다 알맞은 스트라이크 개수를 반환한다`(input: Pair<List<Int>, Int>) {
        val guessNumber = input.first
        val correctAnswer = input.second
        val (strike, _) = judge.compare(guessNumber)

        assertThat(strike).isEqualTo(correctAnswer)
    }

    @ParameterizedTest
    @MethodSource("ballListProvider")
    fun `심판은 각 자리수마다 알맞은 볼 개수를 반환한다`(input: Pair<List<Int>, Int>) {
        val guessNumber = input.first
        val correctAnswer = input.second
        val (_, ball) = judge.compare(guessNumber)

        assertThat(ball).isEqualTo(correctAnswer)
    }
}