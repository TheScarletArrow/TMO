import util.ArrayUtils.Companion.divideArrays
import util.ArrayUtils.Companion.sumArrays

data class ModelParams(
    val numberPlaceInQueue: Int,
    val channelNumber: Int,
    val freePlacesInQueue: Int,
    val freeChannels: Int
)

class Statistics {
    fun identifyModelState(modelParams: ModelParams): Array<Int> {
        var caseNumber: Int = modelParams.numberPlaceInQueue + modelParams.channelNumber + 1
        var busyChannelsNumber: Int = modelParams.channelNumber - modelParams.freeChannels
        var busyPlacesInQueueNumber: Int = modelParams.numberPlaceInQueue - modelParams.freePlacesInQueue

        val state = Array<Int>(caseNumber) { 0 }
        state[busyChannelsNumber + busyPlacesInQueueNumber] = 1
        return state
    }

    //argument is 3-dimensional array

    fun calculateStatistics(
        modelStatistics: Array<Array<Array<Double>>>,
        runNumber: Int
    ): Array<Array<Double>> {
        val statistics = modelStatistics[0]

        for (i: Int in 1..modelStatistics.size) {
            val model = modelStatistics[i]

            for (j: Int in 0..model.size) {
                val modelState = model[j]
                statistics[j] = sumArrays(statistics[j], modelState)
            }
        }
        for (i: Int in 0..statistics.size) {
            statistics[i] = divideArrays(statistics[i], runNumber)
        }

        return statistics
    }

    fun printStatistics(statistics: Array<Array<Double>>, step:Int) {
        for (i: Int in 0..statistics.size) {
            println(statistics[i].contentToString())
        }
    }
}