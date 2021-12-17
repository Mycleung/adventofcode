package main.kotlin.day5

import main.kotlin.common.Common
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val input = Common.readFileLinesToString("input5.txt")
    val map = Map()
    input.forEach{
        val parts = it.split(" -> ")
        val left = parts[0].split(",")
        val right = parts[1].split(",")
        val xStart = left[0].toInt()
        val yStart = left[1].toInt()
        val xEnd = right[0].toInt()
        val yEnd = right[1].toInt()

        val xMin = min(xStart, xEnd)
        val yMin = min(yStart, yEnd)
        val xMax = max(xStart, xEnd)
        val yMax = max(yStart, yEnd)

        if (xMin == xMax) {
            map.growX(xMin)
            for (i in yMin..yMax) {

                map.growY(xMin, i)
                map.map[xMin][i].count += 1
            }
        }  else if (yMin == yMax) {
            map.growX(max(xMin, xMax))
            for (i in xMin..xMax) {
                map.growY(i, yMin)
                map.map[i][yMin].count += 1
            }
        } else {
            // Diagonal
            map.growX(max(xMin, xMax))
            for (i in xMin..xMax) {
                map.growY(i, max(yMin, yMax))
            }
            val xs = stepThrough(xStart, xEnd)
            val ys = stepThrough(yStart, yEnd)
            for (i in xs.indices) {
                map.map[xs[i]][ys[i]].count += 1
            }
        }
    }
    println(map)
    println(map.countGreaterEqual(2))
}

enum class Direction {
    HORIZONTAL, VERTICAL, DIAGONAL
}

fun stepThrough(start: Int, end: Int): List<Int> {
    val r = mutableListOf<Int>(start)
    var i = start
    val step = (end - start) / abs(end - start)
    while (i != end) {
        i += step
        r.add(i)
    }
    return r
}

data class Point(val x: Int, val y: Int, var count: Int) {
    override fun toString(): String {
        return "$x,$y ($count)"
    }
}

class Map() {
    val map: MutableList<MutableList<Point>> = mutableListOf()

    fun growX(x: Int) {
        val xGrowth = x - map.size + 1
        if (xGrowth > 0) {
            for (i in 0 until xGrowth) {
                map.add(mutableListOf())
            }
        }
    }

    fun growY(x: Int, y: Int) {
        val yGrowth = y - map[x].size + 1
        if (yGrowth > 0) {
            for (j in 0 until yGrowth) {
                map[x].add(Point(x, map[x].size, 0))
            }
        }
    }

    fun countGreaterEqual(n: Int): Int {
        var acc = 0
        map.forEach{ row ->
            row.forEach{
                if (it.count >= n) {
                    acc += 1
                }
            }
        }
        return acc
    }

    override fun toString(): String {
        return map.joinToString("\n")
    }
}
