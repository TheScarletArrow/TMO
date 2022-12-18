import util.ArrayUtils.Companion.divideArrays
import util.ArrayUtils.Companion.sumArrays
import java.util.Arrays

data class ModelParams(
    var numberPlaceInQueue: Int,
    var channelNumber: Int,
    var freePlacesInQueue: Int,
    var freeChannels: Int
)
typealias StatisticsData = Array<Array<Double>>
    fun identifyModelState(modelParams: ModelParams): Array<Double> {
        var caseNumber: Int = modelParams.numberPlaceInQueue + modelParams.channelNumber + 1
        var busyChannelsNumber: Int = modelParams.channelNumber - modelParams.freeChannels
        var busyPlacesInQueueNumber: Int = modelParams.numberPlaceInQueue - modelParams.freePlacesInQueue

        //create array of doubles with size = caseNumber
        var result: Array<Double> = Array(caseNumber) { 0.0 }

        result[busyChannelsNumber + busyPlacesInQueueNumber] = 1.0
        return result
    }

    //argument is 3-dimensional array

    fun calculateStatistics(
        modelStatistics: Array<Array<Array<Double>>>,
        runNumber: Int
    ): Array<Array<Double>> {
        var statistics = modelStatistics[0]
//print models statistics
//        println( modelStatistics.contentToString())
//        print modelStatistics

        for (i in 1 until modelStatistics.size) {
            var model = modelStatistics[i]
            for (j: Int in model.indices) {
                val modelState = model[j]
                statistics[j] = sumArrays(statistics[j], modelState)
            }
        }
        for (i: Int in statistics.indices) {
            statistics[i] = divideArrays(statistics[i], runNumber)
        }
        return statistics
    }

    fun printStatistics(statistics: Array<Array<Double>>, step:Int) {

        for (element in statistics) {

            println(element.contentToString())
        }
    }
