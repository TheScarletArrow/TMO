package util

import kotlin.math.ln


class Lcg() {
    val a: Long = 4827
    val c: Long = 0
    val m: Long = 2147483647
    var state = 1%m;

    fun nextInt(): Double {
        state = (a * state + c) % m
        return state * 1.0 / m
    }
}


val bsd = Lcg()
fun customRandom(number: Int): Double {
    return ln((1 - bsd.nextInt()).toDouble()) / (-number) * 1000
}
