
fun main() {
    println("Advent of Code 2022")
    println()
    (1..25).forEach {
        val f = String.format("%02d", it)
        try {
            val clazz = Class.forName("day$f.Day$f")
            val day = clazz.getConstructor().newInstance() as Day
            day.run()
        } catch (_: ClassNotFoundException) {
        }
    }
}
