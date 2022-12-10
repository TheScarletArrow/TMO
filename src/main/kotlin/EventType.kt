enum class EventType {
    ADD, REMOVE, COLLECT
}
data class Event(val type: EventType, val time: Int)