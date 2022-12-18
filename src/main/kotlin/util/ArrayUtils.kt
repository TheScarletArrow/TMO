package util

class ArrayUtils {
    companion object {
        fun sumArrays(array1: Array<Double>, array2: Array<Double>): Array<Double> {
            //попарно просуммировать элементы массивов
            for (i: Int in array1.indices) {
                array1[i] = array1[i] + array2[i]
            }

            return array1
        }

        fun divideArrays(array1: Array<Double>, runNumber: Int): Array<Double> {

            return array1.map { it / runNumber }.toTypedArray()
        }
    }
}