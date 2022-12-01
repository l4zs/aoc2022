import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

abstract class Day(private val number: Int, private val title: String) {

    private val inputPath: Path = Paths.get(this.javaClass.getResource("input.txt")!!.toURI())

    val inputFile: File = inputPath.toFile()

    fun run() {
        println("--- Day $number: $title ---")
        println()
        println("Part One: ${partOne()}")
        println("Part Two: ${partTwo()}")
        println()
    }

    abstract fun partOne(): Any

    abstract fun partTwo(): Any
}
