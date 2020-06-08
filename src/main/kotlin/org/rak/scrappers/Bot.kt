package org.rak.scrappers

import org.rak.scrappers.parts.*

class Bot(val name: String) {
    var head = PartSlot(PartType.HEAD, DEFAULT_HEAD)
    var leftArm = PartSlot(PartType.LEFT_ARM, DEFAULT_LEFT_ARM)
    var rightArm = PartSlot(PartType.RIGHT_ARM, DEFAULT_RIGHT_ARM)
    var legs = PartSlot(PartType.LEGS, DEFAULT_LEGS)

    fun attemptEquip(part: Part) {
        when (part.type) {
            PartType.HEAD -> head.attemptEquip(part)
            PartType.LEFT_ARM -> leftArm.attemptEquip(part)
            PartType.RIGHT_ARM -> rightArm.attemptEquip(part)
            PartType.LEGS -> legs.attemptEquip(part)
        }
    }
}