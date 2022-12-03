package day03

import Day

class Day03 : Day(3, "Rucksack Reorganization") {

    override fun partOne(): Any {
        return inputFile.readLines()
            .map { it.map { s -> s } }
            .map { it.chunked(it.size / 2) }
            .map { (a, b) -> a.toSet().intersect(b.toSet()).first() }
            .sumOf { if (it.isUpperCase()) it.code - 64 + 26 else it.code - 96 }
    }

    override fun partTwo(): Any {
        return inputFile.readLines()
            .chunked(3)
            .map { (a, b, c) -> a.toSet().intersect(b.toSet()).intersect(c.toSet()).first() }
            .sumOf { if (it.isUpperCase()) it.code - 64 + 26 else it.code - 96 }
    }
}
