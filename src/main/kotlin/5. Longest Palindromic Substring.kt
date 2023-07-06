fun main(args: Array<String>) {
    print(longestPalindrome("babad"))
}

fun longestPalindrome(s: String): String {
    val result = intArrayOf(0, 0)

    for (i in s.indices) {
        val oddLength = expand(i, i, s)
        if (oddLength > result[1] - result[0] + 1) {
            val dist = oddLength / 2
            result[0] = i - dist
            result[1] = i + dist
        }

        val evenLength = expand(i, i + 1, s)
        if (evenLength > result[1] - result[0] + 1) {
            val dist = (evenLength / 2) - 1
            result[0] = i - dist
            result[1] = i + 1 + dist
        }
    }

    return s.substring(result[0], result[1] + 1)
}

private fun expand(i: Int, j: Int, s: String): Int {
    var left = i
    var right = j

    while (left >= 0 && right < s.length && s[left] == s[right]) {
        left--
        right++
    }

    return right - left - 1
}