data class Person(val name: String, val surname: String, val age: Int)

fun main() {
    val numbers = IntArray(100) { it }
        .filter { it % 2 == 0 }
        .slice(10..20)
        .sumOf { it + 1 }
    println(numbers)

    val persons = listOf(
        Person("Rita", "Dedova", 99),
        Person("Anton", "Kazakov", 30),
        Person("Anton", "Romanov", 40),
        Person("Dmitry", "Prokofev", 35),
        Person("Dmitry", "Ognev", 32),
        Person("Dmitry", "Kuchanov", 39)
    )

    println(persons)
    println(persons.sortAge())
    println(persons.sortName())
    println(around { persons.sortAge() })
    println(around { persons.sortName() })

}

fun List<Person>.sortAge() = sortedWith(compareByDescending { it.age })

fun List<Person>.sortName() = sortedWith(compareBy({ it.name }, { it.surname }))

fun around(action: () -> Unit): Long {
    val start = System.currentTimeMillis()
    action()
    return System.currentTimeMillis() - start
}