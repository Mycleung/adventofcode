import main.kotlin.common.Common
import java.lang.Integer


fun main(args: Array<String>) {
    val input = Common.readFileLinesToInt("input1.txt")
    var previous = Integer.MAX_VALUE
    var increase = 0
    input.forEach{
        if (it > previous) {
            increase += 1
        }
        previous = it
    }
    println("1-1: $increase")

    previous = Integer.MAX_VALUE
    increase = 0
    input.windowed(3).forEach{
        val sum = it.reduce{ acc, ii -> acc + ii }
        if (sum > previous) {
            increase += 1
        }
        previous = sum
    }

    println("1-2: $increase")
}

