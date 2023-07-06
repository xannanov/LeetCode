fun main(args: Array<String>) {
    print(convert("PAYPALISHIRING", 4))
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s

    val result = StringBuilder()
    val res: Array<ArrayList<String>> = Array(numRows) {
        ArrayList<String>()
    }

    var index = 0
    var step = 1
    s.forEach {
        res[index].add(it.toString())
        if (index == 0)
            step = 1
        else if (index == numRows - 1)
            step = -1
        index += step
    }

    res.forEach {
        it.forEach {
            result.append(it)
        }
    }

    return result.toString()
}