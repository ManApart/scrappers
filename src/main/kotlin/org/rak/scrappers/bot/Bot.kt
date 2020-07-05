package org.rak.scrappers.bot

import org.rak.scrappers.effect.CurrentEffect
import org.rak.scrappers.move.Move
import org.rak.scrappers.part.*

class Bot(val id: String, val name: String) {
    val effects = mutableListOf<CurrentEffect>()

    var head = PartSlot(PartType.HEAD, DEFAULT_HEAD)
    var leftArm = PartSlot(PartType.LEFT_ARM, DEFAULT_LEFT_ARM)
    var rightArm = PartSlot(PartType.RIGHT_ARM, DEFAULT_RIGHT_ARM)
    var legs = PartSlot(PartType.LEGS, DEFAULT_LEGS)
    var currentEnergy: Int = 0

    fun attemptEquip(part: Part): Boolean {
        return when (part.type) {
            PartType.HEAD -> head.attemptEquip(part)
            PartType.LEFT_ARM -> leftArm.attemptEquip(part)
            PartType.RIGHT_ARM -> rightArm.attemptEquip(part)
            PartType.LEGS -> legs.attemptEquip(part)
        }
    }

    private fun getPartSlots(): List<PartSlot> {
        return listOf(head, leftArm, rightArm, legs)
    }

    private fun getParts(): List<Part> {
        return getPartSlots().map { it.part }
    }

    fun getMove(moveId: String): Move? {
        return getParts().firstOrNull { it.moveId == moveId }?.getMove()
    }

    fun getTotalHealth() : Int {
        return getParts().sumBy { it.totalHealth }
    }

    fun getTotalEnergy() : Int {
        return getParts().sumBy { it.totalHealth }
    }

    fun resetStats() {
        currentEnergy = getTotalEnergy()
        getPartSlots().forEach { it.health = it.part.totalHealth }
    }
}