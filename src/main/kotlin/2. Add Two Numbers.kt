class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print(currentString: StringBuilder = StringBuilder()): Unit? {
        if (next == null) {
            println(currentString.append(`val`).toString())
        }

        return next?.print(currentString.append(`val`))
    }
}

fun main(args: Array<String>) {
    val node = ListNode(9).apply {
        next = ListNode(9).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9).apply {
                        next = ListNode(9).apply {
                            next = ListNode(9)
                        }
                    }
                }
            }
        }
    }
    val node2 = ListNode(9).apply {
        next = ListNode(9).apply {
            next = ListNode(9).apply {
                next = ListNode(9)
            }
        }
    }

    val node3 = ListNode(0)
    val node4 = ListNode(0)

    val node5 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }
    val node6 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    val node7 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(9)
        }
    }

    val node8 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4).apply {
                next = ListNode(9)
            }
        }
    }

    val res = node7.sumTo(node8, isFirst = true)
    res?.print()
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    return l1.sumTo(l2, isFirst = true)
}

fun ListNode?.sumTo(
    other: ListNode?,
    startNode: ListNode = ListNode(0),
    currentNode: ListNode? = ListNode(0),
    additionalRank: Boolean = false,
    isFirst: Boolean = false
): ListNode? {
    val currentNodeValue = ((this?.`val` ?: 0) + (other?.`val` ?: 0) + if (additionalRank) 1 else 0)
    if (isFirst) {
        startNode.`val` = currentNodeValue % 10
    } else {
        currentNode?.`val` = currentNodeValue % 10
    }

    if (this?.next != null || other?.next != null) {
        if (isFirst) startNode.next = ListNode(0)
        else currentNode?.next = ListNode(0)
        return if (other?.next == null)
            this?.next?.sumTo(
                other?.next,
                startNode,
                if (isFirst) startNode.next else currentNode?.next,
                currentNodeValue > 9
            )
        else
            other.next?.sumTo(
                this?.next,
                startNode,
                if (isFirst) startNode.next else currentNode?.next,
                currentNodeValue > 9
            )
    }

    if (currentNodeValue > 9) {
        if (isFirst)
            startNode.next = ListNode(1)
        else
            currentNode?.next = ListNode(1)
    }
    return startNode
}