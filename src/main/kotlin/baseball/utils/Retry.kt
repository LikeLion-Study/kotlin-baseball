package baseball.utils

fun <T> retryInput(runBlock: () -> T, onError: (String?) -> Unit): T {
    while (true) {
        runCatching {
            return runBlock()
        }.onFailure { exception ->
            onError(exception.message)
        }
    }
}