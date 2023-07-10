fun main(args: Array<String>) {
    print(isMatch("aavava", "a*.*"))
}

fun isMatch(s: String, p: String): Boolean {
    if (p == ".*") return true

    val cache = HashMap<Pair<Int, Int>, Boolean>()

    fun dfs(i: Int, j: Int): Boolean {
        if (cache.contains(i to j))
            return cache[i to j]!!

        if (i >= s.length && j >= p.length)
            return true
        else if (j >= p.length)
            return false

        val match = i < s.length && (s[i] == p[j] || p[j] == '.')

        if (j + 1 < p.length && p[j + 1] == '*') {
            cache[i to j] = dfs(i, j + 2) || match && dfs(i + 1, j)
            return cache[i to j]!!
        }

        if (match) {
            cache[i to j] = dfs(i + 1, j + 1)
            return cache[i to j]!!
        }

        cache[i to j] = false
        return false
    }

    return dfs(0, 0)
}