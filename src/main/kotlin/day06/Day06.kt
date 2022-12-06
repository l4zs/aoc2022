package day06

import Day

class Day06 : Day(6, "Tuning Trouble") {

    override fun partOne(): Int {
        return firstPacket(4)
    }

    override fun partTwo(): Any {
        return firstPacket(14)
    }

    private fun firstPacket(distinctChars: Int) : Int {
        return inputFile.readText()
            .windowed(distinctChars)
            .withIndex()
            .first { (_, v) -> v.toList().distinct().size == v.length }
            .index + distinctChars
    }
}
