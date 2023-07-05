fun main(args: Array<String>) {
    print(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val resultArray = IntArray(nums1.size + nums2.size)

    var i = 0
    var j = 0
    var resK = 0

    while (i < nums1.size || j < nums2.size) {
        if (i >= nums1.size) {
            while (j < nums2.size) {
                resultArray[resK++] = nums2[j++]
            }
            break
        } else if (j >= nums2.size) {
            while (i < nums1.size) {
                resultArray[resK++] = nums1[i++]
            }
            break
        }

        if (nums1[i] < nums2[j]) {
            resultArray[resK++] = nums1[i++]
        } else {
            resultArray[resK++] = nums2[j++]
        }
    }

    return if (resultArray.size % 2 != 0)
        resultArray[resultArray.size / 2].toDouble()
    else (resultArray[resultArray.size / 2 - 1].toDouble() + resultArray[resultArray.size / 2].toDouble()) / 2
}