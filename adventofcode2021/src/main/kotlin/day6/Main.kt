package main.kotlin.day6

import main.kotlin.common.Common
import kotlin.math.max

fun main(args: Array<String>) {
    val input = Common.readFileLinesToString("input6.txt")
    val startingFish = input[0].split(",").map{ it.toInt() }
    val fishByTimer = MutableList(9) { 0.toBigInteger() }
    for (i in startingFish) {
        fishByTimer[i] += 1.toBigInteger()
    }

    val daysToIterate = 256

    repeat(daysToIterate) {
        val popped = fishByTimer.removeFirst()
        fishByTimer[6] += popped
        fishByTimer.add(popped)
    }

    val total = fishByTimer.fold(0.toBigInteger()) { acc, it -> acc + it }
    println(total)
}