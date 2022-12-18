import models.FutureEventList
import util.customRandom

class SimulationModelParam {
    var numberServiceChannels: Int
    var numberPlaceInQueue: Int
    var intensityServiceApps: Int
    var intensityReceiptApps: Int
    var statisticsStep: Int
    var timeLimit: Int

    //allParamsConstructor
    constructor(numberServiceChannels: Int, numberPlaceInQueue: Int, intensityServiceApps: Int, intensityReceiptApps: Int, statisticsStep: Int, timeLimit: Int) {
        this.numberServiceChannels = numberServiceChannels
        this.numberPlaceInQueue = numberPlaceInQueue
        this.intensityServiceApps = intensityServiceApps
        this.intensityReceiptApps = intensityReceiptApps
        this.statisticsStep = statisticsStep
        this.timeLimit = timeLimit
    }
}


fun simulationModel(simulationModelParam: SimulationModelParam): StatisticsData {


    var list = FutureEventList()
    var statisticsData: StatisticsData = arrayOf()

    var numberAllApps = 0
    var numberRejectedApps = 0
    var numberFreePlacesInQueue = simulationModelParam.numberPlaceInQueue
    var numberFreeChannels = simulationModelParam.numberServiceChannels

    list.add(Event(EventType.ADD, customRandom(simulationModelParam.intensityReceiptApps).toInt()))
    list.add(Event(EventType.COLLECT, simulationModelParam.statisticsStep))

    var numberCollectStatistics = 1
    for (modelTime in 0 until simulationModelParam.timeLimit) {
        var event = list.pop(modelTime)

        if (event?.type == EventType.ADD) {
            numberAllApps++
            if (numberFreeChannels > 0) {
                numberFreeChannels--
                list.add(Event(EventType.REMOVE, modelTime + customRandom(simulationModelParam.intensityServiceApps).toInt()))
            } else if (numberFreePlacesInQueue > 0) {
                numberFreePlacesInQueue--
            } else {
                numberRejectedApps++
            }
            list.add(Event(EventType.ADD, modelTime + customRandom(simulationModelParam.intensityReceiptApps).toInt()))
        }
        if (event?.type == EventType.REMOVE) {
            if (numberFreePlacesInQueue < simulationModelParam.numberPlaceInQueue) {
                numberFreePlacesInQueue++
                list.add(Event(EventType.REMOVE, modelTime + customRandom(simulationModelParam.intensityServiceApps).toInt()))
            } else {
                numberFreeChannels++
            }
        }
        if (event?.type == EventType.COLLECT) {
            //push to statisticsData
            statisticsData = statisticsData.plus(identifyModelState(ModelParams(
                    numberPlaceInQueue = simulationModelParam.numberPlaceInQueue,
                    channelNumber = simulationModelParam.numberServiceChannels,
                    freeChannels = numberFreeChannels,
                    freePlacesInQueue = numberFreePlacesInQueue,
            )))
            numberCollectStatistics++
            list.add(Event(EventType.COLLECT, simulationModelParam.statisticsStep * numberCollectStatistics))
        }
    }
    statisticsData = statisticsData.plus(identifyModelState(ModelParams(
            numberPlaceInQueue = simulationModelParam.numberPlaceInQueue,
            channelNumber = simulationModelParam.numberServiceChannels,
            freeChannels = numberFreeChannels,
            freePlacesInQueue = numberFreePlacesInQueue,
    )))


//    statisticsData.forEach { println(it.contentToString()) }

    return statisticsData


}