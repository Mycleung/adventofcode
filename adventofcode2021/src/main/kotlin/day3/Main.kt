package main.kotlin.day3

import main.kotlin.common.Common
import kotlin.math.floor

fun main(args: Array<String>) {
    val input = Common.readFileLinesToString("input3.txt")

    // Initialise counter list of empty pairs with
    // length the same as the number of characters in a line
    var counter: MutableList<Pair<Int,Int>> = MutableList(input[0].length) { _ -> Pair(0,0) }

    input.forEach{
        for (i in it.indices) {
            when (it[i]) {
                // These two lines feel like I'm doing crimes
                "0".single() -> counter[i] = Pair(counter[i].first + 1, counter[i].second)
                "1".single() -> counter[i] = Pair(counter[i].first, counter[i].second + 1)
            }
        }
    }

    var gamma = 0
    var epsilon = 0

    counter.forEach{
        // Bit shift left
        gamma = gamma shl 1
        epsilon = epsilon shl 1
        // Fill in next number
        if (it.first > it.second) {
            gamma += 1
        } else {
            epsilon += 1
        }
    }
    println(gamma * epsilon)

    // Part 2
    // I think this is the ugliest solution I could have come up with?
    var sorted = input.sorted()
    for (i in 0 until input[0].length) {
        if (sorted.size == 1) {
            break
        }
        val half = floor(sorted.size.toDouble() / 2).toInt()
        when (sorted[half][i]) {
            "0".single() -> {
                sorted = sorted.filter{it[i] == "0".single()}
            }
            "1".single() -> {
                sorted = sorted.filter{it[i] == "1".single()}
            }
        }
    }
    val oxygen = Integer.parseInt(sorted[0], 2)
    sorted = input.sorted()
    for (i in 0 until input[0].length) {
        if (sorted.size == 1) {
            break
        }
        val half = floor(sorted.size.toDouble() / 2).toInt()
        when (sorted[half][i]) {
            "0".single() -> {
                sorted = sorted.filter{it[i] == "1".single()}
            }
            "1".single() -> {
                sorted = sorted.filter{it[i] == "0".single()}
            }
        }
    }
    val carbon = Integer.parseInt(sorted[0], 2)
    println(oxygen * carbon)
}
