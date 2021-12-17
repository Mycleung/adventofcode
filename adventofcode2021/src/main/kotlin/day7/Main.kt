package main.kotlin.day7

import main.kotlin.common.Common
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val input = Common.readFileLinesToString("input7.txt")
    val start = input[0].split(",").map{ it.toInt() }
    val limits = start.fold(Pair(Integer.MAX_VALUE,0)) { acc, it ->
        val min = min(acc.first, it)
        val max = max(acc.second, it)
        Pair(min, max)
    }
    val min = limits.first
    val max = limits.second
    val size = max-min+1

    val crabsByX = MutableList(size) { 0 }
    start.forEach{ crabsByX[it-min] += 1 }

    val fuelByX = List(crabsByX.size) { ii ->
        crabsByX.foldIndexed(0) { jj, acc, it ->
            acc + (triangle(abs(ii - jj)) * it)
        }
    }

    println(fuelByX.minOrNull())
}

fun triangle(i: Int): Int {
    return (i * (i + 1)) / 2
}