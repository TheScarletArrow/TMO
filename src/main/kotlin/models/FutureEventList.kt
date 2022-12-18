package models

import Event

class FutureEventList {
var list: List<Event> = ArrayList()

    constructor(list: List<Event>) {
        this.list = list
    }
    constructor(){
        this.list = ArrayList()
    }
    fun length(): Int {
        return list.size
    }

    fun add(event: Event) {
        list = list.plus(event).sortedBy { it.time }

    }

    fun pop(time: Int): Event? {
        return if (list[0].time <= time) {
            //pop last element
            var event = list[0]
            list = list.drop(1)
            event
        } else null


    }

    override fun toString(): String {
        return "FutureEventList(list=$list)"
    }
}