package day04

import Day

class Day04 : Day(4, "Camp Cleanup") {

    override fun partOne(): Any {
        return inputFile.readLines()
            .map { Regex("""\d+""").findAll(it).toList().map { d -> d.value.toInt() } }
            .count { (a, b, c, d) -> (a in c..d && b in c..d) || (c in a..b && d in a..b) }
    }

    override fun partTwo(): Any {
        return inputFile.readLines()
            .map { Regex("""\d+""").findAll(it).toList().map { d -> d.value.toInt() } }
            .count { (a, b, c, d) -> (a..b).intersect(c..d).isNotEmpty() }
    }
}
