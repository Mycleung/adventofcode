package main.kotlin.day8

import main.kotlin.common.Common

fun main(args: Array<String>) {
    val input = Common.readFileLinesToString("input8.txt")

    var uniqueDigits = 0
    input.forEach{
        val outputs: List<String> = it.split(" | ").last().split(" ")
        uniqueDigits += outputs.count { it.length in listOf(2, 3, 4, 7) }
    }

    println(uniqueDigits)
}