import java.lang.Integer.min
import kotlin.math.max

fun main(args: Array<String>) {
    print(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}

fun maxArea(height: IntArray): Int {

    var left = 0
    var right = height.size - 1
    var maximum = 0

    while (left < right) {
        maximum = max(maximum, min(height[left], height[right]) * (right - left))

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maximum
}