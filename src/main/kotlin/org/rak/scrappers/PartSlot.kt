package org.rak.scrappers

import org.rak.scrappers.parts.Part
import org.rak.scrappers.parts.PartType

class PartSlot(private val type: PartType, var part: Part) {
    fun attemptEquip(part: Part) {
        if (canEquip(part)){
            this.part = part
        }
    }

    private fun canEquip(part: Part) : Boolean {
        return part.type == type
    }


}