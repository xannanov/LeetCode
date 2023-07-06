import java.lang.NumberFormatException

fun main(args: Array<String>) {
    print(reverse(-120))
}

fun reverse(x: Int): Int =
    try {
        if (x < 0) {
            -x.toString().substring(1).reversed().toInt()
        } else {
            x.toString().reversed().toInt()
        }
    } catch (e: NumberFormatException) {
        0
    }