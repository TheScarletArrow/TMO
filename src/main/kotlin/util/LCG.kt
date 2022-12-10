package util

import kotlin.math.ln


class Lcg() {
    val a: Long = 1664525
    val c: Long = 123563
    val m: Long = 2147483647
    val d: Long = 1 % m
    val s: Long = 0

    private var state = s

    fun nextInt(): Long {
        state = (a * state + c) % m
        return state / d
    }
}


val bsd = Lcg()
fun customRandom(number: Long): Double {
    return ln(( bsd.nextInt()).toDouble()) /(number)*1000.0
}
