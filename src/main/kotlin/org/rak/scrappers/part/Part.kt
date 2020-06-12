package org.rak.scrappers.part

import com.fasterxml.jackson.annotation.JsonIgnore
import org.rak.scrappers.Resources
import org.rak.scrappers.move.Move

val DEFAULT_HEAD = Part("basic_head", "Basic Head", PartType.HEAD, 10)
val DEFAULT_LEFT_ARM = Part("basic_left_arm", "Basic Left Arm", PartType.LEFT_ARM, 10)
val DEFAULT_RIGHT_ARM = Part("basic_right_arm", "Basic Right Arm", PartType.RIGHT_ARM, 10)
val DEFAULT_LEGS = Part("basic_legs", "Basic Legs", PartType.LEGS, 10)


class Part(val id: String, val name: String, val type: PartType, val totalHealth: Int = 25, val energy: Int = 25, val speed: Int = 25, val moveIds: List<String> = listOf()) {
    var health = totalHealth

    private val moveList by lazy { moveIds.mapNotNull { Resources.moves[it] } }

    @JsonIgnore
    fun getMoves() : List<Move> {
        return moveList
    }
}