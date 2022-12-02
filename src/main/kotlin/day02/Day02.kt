package day02

import Day

class Day02 : Day(2, "Rock Paper Scissors") {

    override fun partOne(): Any {
        return inputFile.readLines().map { it.split(" ") }.map { (opponent, response) ->
            opponent.first().code - 64 to response.first().code - (64 + 23)
        }.map { (opponent, play) ->
            play + if (opponent == play) 3 else if (opponent == (play + 1) % 3 + 1) 6 else 0
        }.sum()
    }

    override fun partTwo(): Any {
        return inputFile.readLines().map { it.split(" ") }.map { (opponent, response) ->
            opponent.first().code - 64 to response.first().code - (64 + 23)
        }.map { (opponent, response) ->
            opponent to if (response == 1) (opponent + 1) % 3 + 1 else if (response == 2) opponent else opponent % 3 + 1
        }.map { (opponent, response) ->
            response + if (opponent == response) 3 else if (opponent == (response + 1) % 3 + 1) 6 else 0
        }.sum()
    }
}
