package day01

import Day

class Day01 : Day(1, "Calorie Counting") {

    override fun partOne(): Any {
        return inputFile.readLines().joinToString("\n").split("\n\n").map {
            it.split("\n").map { line -> line.toLong() }
        }.maxOfOrNull { it.sum() } ?: 0
    }

    override fun partTwo(): Any {
        return inputFile.readLines().joinToString("\n").split("\n\n").map {
            it.split("\n").map { line -> line.toLong() }
        }.map { it.sum() }.sorted().takeLast(3).sum()
    }
}
