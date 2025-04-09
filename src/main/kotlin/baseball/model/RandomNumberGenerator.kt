package baseball.model

import kotlin.random.Random

object RandomNumberGenerator {
    fun generate(): List<Int> {
        val randomNumbers = mutableListOf<Int>()

        while (randomNumbers.size < 3) {
            val randomNumber = Random.nextInt(1, 10)
            if (randomNumber !in randomNumbers) randomNumbers.add(randomNumber)
        }
        return randomNumbers
    }
}