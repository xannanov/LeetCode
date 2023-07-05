fun main(args: Array<String>) {
    println(lengthOfLongestSubstring("aab"))
}

fun lengthOfLongestSubstring(s: String): Int {
    val set = hashSetOf<Char>()

    var bestResult = 0
    var tempResult = 0

    var i = 0
    var needToDown = 0
    while (i < s.length) {
        if (!set.contains(s[i])) {
            if (set.isEmpty())
                needToDown = i + 1
            set.add(s[i])
            tempResult++
        } else {
            if (tempResult > bestResult) {
                bestResult = tempResult
            }
            set.clear()
            i = needToDown
            tempResult = 0
            continue
        }
        i++
    }

    if (s.length == 1) return 1
    if (tempResult > bestResult) bestResult = tempResult
    return bestResult
}