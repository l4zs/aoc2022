package day07

import Day

class Day07 : Day(7, "No Space Left On Device") {

    data class File(
        val name: String,
        val size: Long
    )

    data class Directory(
        val name: String,
        val parent: Directory? = null,
        val files: MutableList<File> = mutableListOf(),
        val directories: MutableList<Directory> = mutableListOf()
    ) {
        fun size(): Long {
            return files.sumOf { it.size } + directories.sumOf { it.size() }
        }

        fun allChildren(): List<Directory> {
            return directories + directories.flatMap { it.allChildren() }
        }
    }

    private val rootDirectory = Directory("/")

    init {
        var currentDirectory = rootDirectory
        inputFile.readLines().forEach {
            if (it.startsWith("$")) {
                val command = it.substringAfter("$ ")
                if (command.startsWith("cd")) {
                    val name = command.substringAfter("cd ")
                    currentDirectory = if (name == "..") {
                        currentDirectory.parent ?: rootDirectory
                    } else if (name == "/") {
                        rootDirectory
                    } else {
                        if (currentDirectory.directories.any { it.name == name }.not()) {
                            val newDirectory = Directory(name, currentDirectory)
                            currentDirectory.directories.add(newDirectory)
                            newDirectory
                        } else {
                            currentDirectory.directories.first { it.name == name }
                        }
                    }
                }
            } else {
                val (type, name) = it.split(" ")
                if (type == "dir") {
                    currentDirectory.directories.add(Directory(name, currentDirectory))
                } else {
                    currentDirectory.files.add(File(name, type.toLong()))
                }
            }
        }
    }

    override fun partOne(): Any {
        return rootDirectory.allChildren().filter { it.size() <= 100000 }.sumOf { it.size() }
    }

    override fun partTwo(): Any {
        return rootDirectory.allChildren().filter { it.size() >= 30000000 - (70000000 - rootDirectory.size()) }.minOf { it.size() }
    }
}
