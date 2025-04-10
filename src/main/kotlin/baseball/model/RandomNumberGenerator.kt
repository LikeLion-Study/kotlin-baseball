package baseball.model

import baseball.utils.constants.General
import kotlin.random.Random

object RandomNumberGenerator {
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 10

    fun generate(): List<Int> {
        val randomNumbers = mutableListOf<Int>()

        while (randomNumbers.size < General.MAX_NUMBER_COUNT) {
            val randomNumber = Random.nextInt(MIN_NUMBER, MAX_NUMBER)
            if (randomNumber !in randomNumbers) randomNumbers.add(randomNumber)
        }
        return randomNumbers
    }
}