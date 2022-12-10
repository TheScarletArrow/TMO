import models.FutureEventList
import util.Lcg
import util.customRandom

val NUMBER_SERVICE_CHANNELS:Int = 2
val NUMBER_PLACE_IN_QUEUE:Int=3
val ACCEPT_INTENSIVITY: Int = 2
val SERVICE_INTENSIVITY: Int = 1
val TIME_LIMIT: Int = 1000
val STEP_STATISTICS: Int = 100
val NUMBER_OF_EXPERIMENTS: Int = 100
fun main(args: Array<String>) {

    println("First 10 BSD random numbers - seed 0")
    val bsd = Lcg()
    println(bsd.s)
    println(bsd.a)
    println(bsd.c)
    println(bsd.m)
    for (i in 1..10) {
        println(customRandom(bsd.nextInt()))
    }

//futureEventLis
    val futureEventList = listOf<Event>()
    val futureEventList1 = FutureEventList(futureEventList)
    futureEventList1.add(Event( EventType.ADD, 1))

    futureEventList1.add(Event( EventType.ADD, 2))
    futureEventList1.pop(2)
    println(futureEventList1)
}