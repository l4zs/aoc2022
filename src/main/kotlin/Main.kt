import day01.Day01

val days = listOf(
    Day01(),
)

fun main() {
    println("Advent of Code 2022")
    println()
    days.forEach { it.run() }
}
