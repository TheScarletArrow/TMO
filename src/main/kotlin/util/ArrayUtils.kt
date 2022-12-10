package util

class ArrayUtils {
    companion object {
        fun sumArrays(array1: Array<Double>, array2: Array<Double>): Array<Double> {
            val result = Array(array1.size) { 0.0 }
            for (i in array1.indices) {
                result[i] = array1[i] + array2[i]
            }
            return result
        }

        fun divideArrays(array1: Array<Double>, runNumber: Int): Array<Double> {
            val result = Array(array1.size) { 0.0 }
            for (i in array1.indices) {
                result[i] = array1[i] / runNumber
            }
            return result
        }
    }
}