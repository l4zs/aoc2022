package day05

import Day
import java.util.Stack

class Day05 : Day(5, "Supply Stacks") {

    private val inputStacks: List<Stack<Char>>
    private val instructions: List<List<Int>>

    init {
        val (first, second) = inputFile.readLines().joinToString("\n").split("\n\n")
        inputStacks = first.substringBeforeLast("\n")
            .split("\n")
            .map { it.chunked(4).map { item -> Regex("""[A-Z]""").find(item)?.value }.map { s -> s?.first() } }
            .transpose()
            .map { Stack<Char>().apply { addAll(it.filterNotNull().reversed()) } }
        instructions = second.split("\n")
            .map { Regex("""\d+""").findAll(it).toList().map { d -> d.value } }
            .map { it.map { s -> s.toInt() } }
    }

    override fun partOne(): Any {
        @Suppress("UNCHECKED_CAST")
        val stacks = inputStacks.toList().map { it.clone() as Stack<Char> }

        instructions.forEach { (move, from, to) ->
            repeat(move) {
                stacks[from - 1].pop()?.also { char ->
                    stacks[to - 1].push(char)
                }
            }
        }

        return stacks.map { it.last() }.joinToString("")
    }

    override fun partTwo(): Any {
        @Suppress("UNCHECKED_CAST")
        val stacks = inputStacks.toList().map { it.clone() as Stack<Char> }

        instructions.forEach { (move, from, to) ->
            val temp = mutableListOf<Char>()
            repeat(move) {
                stacks[from - 1].pop()?.also { char ->
                    temp.add(char)
                }
            }
            stacks[to - 1].addAll(temp.reversed())
        }

        return stacks.map { it.last() }.joinToString("")
    }

    private fun <E> List<List<E>>.transpose(): List<List<E>> {
        fun <E> List<E>.head(): E = this.first()
        fun <E> List<E>.tail(): List<E> = this.takeLast(this.size - 1)
        fun <E> E.append(xs: List<E>): List<E> = listOf(this).plus(xs)

        filter { it.isNotEmpty() }.let { ys ->
            return when (ys.isNotEmpty()) {
                true -> ys.map { it.head() }.append(ys.map { it.tail() }.transpose())
                else -> emptyList()
            }
        }
    }
}
