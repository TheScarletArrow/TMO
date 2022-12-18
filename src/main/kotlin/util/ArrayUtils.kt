package util

class ArrayUtils {
    companion object {
        fun sumArrays(array1: Array<Double>, array2: Array<Double>): Array<Double> {

            return array1.map { it + array2[array1.indexOf(it)] }.toTypedArray()
        }

        fun divideArrays(array1: Array<Double>, runNumber: Int): Array<Double> {

            return array1.map { it / runNumber }.toTypedArray()
        }
    }
}