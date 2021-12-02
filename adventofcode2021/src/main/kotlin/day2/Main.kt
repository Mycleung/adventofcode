package main.kotlin.day2

import main.kotlin.common.Common

fun main(args: Array<String>) {
    val input = Common.readFileLinesToString("input2.txt")
    var distance = 0
    var depth = 0

    input.map{it.split(" ", limit=2)}.map{Pair(it[0],it[1].toInt())}.forEach{
        when {
            it.first.startsWith("forward") -> distance += it.second
            it.first.startsWith("down") -> depth += it.second
            it.first.startsWith("up") -> depth -= it.second
        }
    }
    println(distance * depth)

    distance = 0
    depth = 0
    var aim = 0
    input.map{it.split(" ", limit=2)}.map{Pair(it[0],it[1].toInt())}.forEach{
        when {
            it.first.startsWith("forward") -> {
                distance += it.second
                depth += aim * it.second
            }
            it.first.startsWith("down") -> aim += it.second
            it.first.startsWith("up") -> aim -= it.second
        }
    }
    println(distance * depth)
}