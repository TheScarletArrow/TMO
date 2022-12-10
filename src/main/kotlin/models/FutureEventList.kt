package models

import Event

class FutureEventList {
    var list: List<Event> = ArrayList()

    constructor(list: List<Event>) {
        this.list = list
    }

    fun length(): Int {
        return list.size
    }

    fun add(event: Event) {
        list = list.plus(event)
        list.sortedBy { it.time }
    }

    fun pop(time: Int): Event? {
        return if (list[list.size - 1].time <= time) {
            //pop last element
            val event = list[list.size - 1]
            list = list.dropLast(1)
            event
        } else null
    }

    override fun toString(): String {
        return "FutureEventList(list=$list)"
    }
}