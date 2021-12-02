package main.kotlin.common

import java.io.File
import java.nio.file.Paths

object Common {
    fun readFileLinesToString(fileName: String): List<String>
        = File(inputPath(fileName)).useLines { it.toList() }

    fun readFileLinesToInt(fileName: String): List<Int>
        = File(inputPath(fileName)).useLines { it.map { it.toInt() }.toList() }

    fun inputPath(fileName: String): String {
        return Paths.get("adventofcode2021", "input", fileName).toAbsolutePath().toString()
    }
}

