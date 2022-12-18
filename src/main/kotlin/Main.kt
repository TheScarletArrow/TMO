import models.FutureEventList
import util.Lcg
import util.customRandom
import java.util.Arrays

val NUMBER_SERVICE_CHANNELS: Int = 3 // число каналов обслуживания
val NUMBER_PLACE_IN_QUEUE: Int = 2 // число мест в очереди
val ACCEPT_INTENSIVITY: Int = 8 // интенсивность поступления заявок
val SERVICE_INTENSIVITY: Int = 2 // интенсивность обслуживания заявок
val TIME_LIMIT: Int = 1500
val STEP_STATISTICS: Int = 100
val NUMBER_OF_EXPERIMENTS: Int = 1000
fun main(args: Array<String>) {

//    println("First 10 BSD random numbers - seed 0")
//    val bsd = Lcg()
//
//    for (i in 1..10) {
//        println((bsd.nextInt()))
//    }
//
////futureEventLis
//    val futureEventList = listOf<Event>()
//    val futureEventList1 = FutureEventList(futureEventList)
//    futureEventList1.add(Event( EventType.ADD, 1))
//
//    futureEventList1.add(Event( EventType.ADD, 2))
//    futureEventList1.pop(2)
//    println(futureEventList1)

    var statisticsData: Array<StatisticsData> = arrayOf()


    for (i in 0 until NUMBER_OF_EXPERIMENTS) {
        val simulationModelParam = SimulationModelParam(
                numberServiceChannels = NUMBER_SERVICE_CHANNELS,
                numberPlaceInQueue = NUMBER_PLACE_IN_QUEUE,
                SERVICE_INTENSIVITY,
                ACCEPT_INTENSIVITY,
                statisticsStep = STEP_STATISTICS,
                timeLimit = TIME_LIMIT)
        val element = simulationModel(simulationModelParam)
        statisticsData += element
    }
    printStatistics(calculateStatistics(statisticsData, NUMBER_OF_EXPERIMENTS), STEP_STATISTICS)

}
