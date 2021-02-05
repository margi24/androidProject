import java.math.BigInteger
import java.time.temporal.TemporalAmount
import kotlin.random.Random



/////////////////1

val systolic = Random.nextInt(0,300)
val diastolic = Random.nextInt(0,300)
print("$systolic $diastolic")
print(
    when {
        systolic < 120 && diastolic < 80 -> "normal"
        systolic in 120..130 && diastolic < 80 -> "elevated"
        systolic in 130..140 || diastolic in 80..90 -> "high blood pressure stage1"
        systolic in 140..180 || diastolic in 90..120 -> "High blood pressure stage2"
        else -> "hypertensive crisis"
    }
)

/////////////////2

enum class CardType {
    CREDIT, DEBIT
}
enum class TransactionResponse {
    SUCCESS, FAILURE
}
class Card(private val type: CardType, private var balance: Int) {

    private fun isBalanceOk() = balance > 0
    private fun isCreditCard() = type == CardType.CREDIT
    fun pay(amount: Int, limit: Int): TransactionResponse {
        return (when {
            isCreditCard() && balance + limit >= amount -> {
                balance = balance - amount + (amount * Bank.BONUS).toInt()
                TransactionResponse.SUCCESS
            }
            !isCreditCard() && balance > amount -> {
                balance -= amount
                TransactionResponse.SUCCESS
            }
            else -> TransactionResponse.FAILURE
        })
    }

    fun withdraw(amount: Int): TransactionResponse {
        return (when {
            isCreditCard() && balance >= amount -> {
                balance -= amount
                TransactionResponse.SUCCESS
            }
            !isCreditCard() && balance > amount -> {
                balance -= amount
                TransactionResponse.SUCCESS
            }
            else -> TransactionResponse.FAILURE
        })
    }

    fun deposit(amount: Int) { balance += amount }
}

object Bank {
    const val BONUS = 1.5
}

val cardCredit = Card(CardType.CREDIT,100)
cardCredit.deposit(100)
cardCredit.pay(100, 10)
cardCredit.deposit(100)

val cardDebit = Card(CardType.DEBIT,100)
/////3
factorial(6)
fun factorial(number:Int): Int {

    return if (number>0) (1..number).fold(1) { p, elem -> p*elem}
    else 1
}