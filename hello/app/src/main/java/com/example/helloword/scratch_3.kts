data class Rectangle(val x: Int, val y: Int, val w: Int, val h: Int)

class Paint {
    var color: Long = 0x00FF00
    var strokeWidth: Int = 5
    fun drawRectangle(rect: Rectangle) {
        println("Drawing $rect color: $color stroke: $strokeWidth")
    }
}

fun render(paint: Paint?, rectangles: List<Rectangle?>) {
    if (paint != null) {
        paint.color = 0xFF0000
        for (rect in rectangles) {
            if (rect != null) {
                paint.drawRectangle(rect)
            }
        }
    }
}

fun render2(paint: Paint?, rectangles: List<Rectangle?>) {
    paint?.apply {
        color = 0xFF0000
        rectangles.forEach{ it?.let { drawRectangle(it) }}
    }
}


var p = Paint()
var list = listOf(Rectangle(1,2,3,4),Rectangle(5,6,7,8),Rectangle(9,20,20,43))
render(p, list)
render2(p,list)
/////////////////////

data class HeartRateEntry(val date: Long, val value: Int)

fun populateData(vararg dataPair: Pair<Long, Int>): List<HeartRateEntry> =
    dataPair.map { HeartRateEntry(it.first, it.second) }

val data = populateData(
    1612310400L to 76,
    1612310400L to 89,
    1612310400L to 44,
    1612224000L to 47,
    1612224000L to 115,
    1612224000L to 76,
    1612224000L to 87,
    1612137600L to 90,
    1612137600L to 167)

val minOfHeartRate = {elem1: HeartRateEntry, elem2 : HeartRateEntry -> if(elem1.value < elem2.value) elem1 else elem2 }
val ex1data = data
val ex2data = data
val ex3data = data
val ex4data = data
val ex5data = data
println(ex1data.reduce { acc, v -> minOfHeartRate(acc, v)})
println(ex2data.map { it.value }.average())
println(ex3data.filter{ it.value > 100})
println(ex4data.groupBy(HeartRateEntry::date, HeartRateEntry::value))
ex5data.groupBy(HeartRateEntry::date, HeartRateEntry::value).forEach { println(it.value.max()) }



