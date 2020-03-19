import kotlin.math.sqrt

//ex1
open class Account(private var balance: Double) {

    open fun withdraw(amount: Double) {
        balance -= amount
    }

    fun deposit(amount: Double) {
        balance += amount
    }

    fun actualBalance(): Double = balance
}

class SavingAccount(money: Double) : Account(money) {

    private var balance = money

    override fun withdraw(amount: Double) {

        if (amount < super.actualBalance()) {
            super.withdraw(amount)
        } else {
            println("Not enough money to withdraw")
        }

    }
}

val account = Account(12.2)
account.deposit(2.0)
println("The balance is ${account.actualBalance()}")
account.withdraw(10.0)
println("The balance is ${account.actualBalance()}")

val account2 = SavingAccount(13.0)
account2.withdraw(14.0)
println(account2.actualBalance())
account2.withdraw(12.0)
println(account2.actualBalance())

//ex2

//    n
//  v   e
//    s

fun getCardinals(angle: Int): String {
    return when (angle) {
        45 -> "NE"
        315 -> "NV"
        225 -> "SV"
        135 -> "SE"
        in 46..134 -> "E"
        in 134..224 -> "S"
        in 226..314 -> "W"
        in 0..44 -> "N"
        in 316..359 -> "N"
        else -> "Not a good angle"
    }
}

println(getCardinals(35))
println(getCardinals(45))
println(getCardinals(135))

//ex3

fun getNrOfVowels2(word: String) = word.filter { it in "AEIOUaeuio" }.count()
getNrOfVowels2("Dia")

fun getNrOfVowels(word: String): Int {
    val vowels = "aeiouAEIOU"
    var count = 0
    for (i in word) {
        if (vowels.contains(i))
            count++
    }
    return count
}

println(getNrOfVowels("Abracadabra"))
println(getNrOfVowels("brcdbr"))

//ex4

class RectangularShape(var x: Int, var y: Int, var with: Int, var height: Int, var color: Int) {
    fun measure() {}
    fun render() {}
}

fun validateShape(shape: RectangularShape): Boolean {

    return when {
        shape.x < 0 || shape.y < 0 -> {
            print("invalid position"); false
        }
        shape.with > 1024 || shape.height > 1024 -> {
            print("shape too big"); false
        }
        shape.color < 0 || shape.color > 0xFFFFFF -> {
            print("invalid color"); false
        }
        else -> true
    }
}

fun initShape(shape: RectangularShape?) {
    shape?.apply {
        x = 10
        y = 20
        with = 100
        height = 200
        color = 0xFF0066
    } ?: throw IllegalArgumentException()
}

fun drawShape(shape: RectangularShape?) {
    shape?.also {
        validateShape(it)
        it.measure()
        it.render()
    }
}

//ex5

val data = listOf(4, 6, 34, 9, 2, 4, 7)
//a
print(data)
//b
print(data.reversed())
//c
print(data.toSet())
//d
var k = 0
data.iterator().forEach { if (it > 0) k++ }
if (k == data.size) {
    print(data)
}
//e
data.iterator().forEach { println(sqrt(it.toDouble())) }
//f
data.iterator().forEach { if (it % 2 == 0) println(it) }
//g
data.iterator().forEach { if (it % 2 == 1) println(data.indexOf(it)) }
//h&i
var lastPrime = 0
data.iterator().forEach {
    var prime = true
    for (i in 2..sqrt(it.toDouble()).toInt()) {
        if (it % i == 0) {
            prime = false
            break
        }
    }
    if (prime) {
        println(it)
        lastPrime = it
    }
}

print(lastPrime)

//6

data class Student(val name: String, val address: String, val grade: Int)

val students = listOf(
    Student("John", "Boston", 6), Student("Jacob", "Baltimore", 2),
    Student("Edward", "New York", 7), Student("William", "Providence", 6),
    Student("Alice", "Philadelphia", 4), Student("Robert", "Boston", 7),
    Student("Richard", "Boston", 10), Student("Steven", "New York", 3)
)
//a
print(students)
//b
print(students.sortedBy { it.name })
//c
var student1 = students[0]
var it = 1
val st = mutableListOf<Int>()
while (it < students.size) {
    if (student1.name < students[it].name) {
        print(student1)
    }
    student1 = students[it]
}

//d
students.sortedWith(compareBy({ it.grade }, { it.name }))
    .forEach { print(it) }
//e
println(students.groupBy { it.address })

