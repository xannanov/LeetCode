fun main(args: Array<String>) {
    val a = 123321
    println(isPalindrome(a))
}

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    else if (x < 10) return true

    var rank = 0

    var temp = x
    var mn = 1
    while (temp > 0) {
        temp /= 10
        mn *= 10
        rank++
    }

    var left: Int
    var right: Int
    if (rank % 2 == 1) {
        left = rank / 2 - 1
        right = rank / 2 + 1
    } else {
        left = rank / 2 - 1
        right = rank / 2
    }

    while (left >= 0 && right < rank) {
        if (x / 10.pow(left) % 10 != x / 10.pow(right) % 10) return false

        left--
        right++
    }

    return true
}

private fun Int.pow(x: Int): Int =
    if (x == 0) 1
    else (2..x).fold(this) { r, _ -> r * this }