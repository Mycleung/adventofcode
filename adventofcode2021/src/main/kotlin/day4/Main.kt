package main.kotlin.day4

import main.kotlin.common.Common

fun main(args: Array<String>) {
    val input = Common.readFileLinesToString("input4.txt")
    val calledNumbers = input[0].split(",").map{it.toInt()}
    val gridStrings = input.drop(2)
    var grids = gridStrings.chunked(6).map{
        Bingo(it.take(5))
    }.toMutableList()

    calledNumbers.forEach{called ->
        for (i in grids.size - 1 downTo 0) {
            val check = grids[i].check(called)
            if (check != -1) {
                println("Board complete:\n" + grids[i])
                println("Called: $called")
                println(check)
                grids.removeAt(i)
            }
        }
    }
}

class Bingo(input: List<String>) {
    private val grid: List<List<Spot>> = input.map{it.trim().split("  "," ").map{Spot(it.toInt())}}
    private val size = grid.size

    override fun toString(): String {
        return grid.joinToString("\n")
    }

    fun check(called: Int): Int {
        grid.forEach{
            row -> row.forEach{
                if (it.number == called) {
                    it.ticked = true
                    return this.bingo(called)
                }
            }
        }
        // Not won yet
        return -1
    }

    // Has this sheet won?
    private fun bingo(called: Int): Int {
        // Rows
        grid.forEach{
            if (it.all{spot -> spot.ticked}) {
                return this.score(called)
            }
        }
        // Columns
        for (i in 0 until size) {
            if ((0 until size).all{grid[it][i].ticked}) {
                return this.score(called)
            }
        }
        return -1
    }

    private fun score(called: Int): Int {
        var total = 0
        grid.forEach{ row ->
            row.forEach{
                if (!it.ticked) {
                    total += it.number
                }
            }
        }
        println("Total: $total")
        return total * called
    }
}
data class Spot(val number: Int, var ticked: Boolean = false) {
    override fun toString(): String {
        val fmt = when (ticked) {
            true -> "✅"
            false -> "❌"
        }
        return "("+ "%02d".format(number) +" $fmt)"
    }
}

