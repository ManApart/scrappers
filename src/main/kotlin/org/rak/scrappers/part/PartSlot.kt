package org.rak.scrappers.part

class PartSlot(private val type: PartType, var part: Part) {
    fun attemptEquip(part: Part) : Boolean {
        if (canEquip(part)){
            this.part = part
            return true
        }
        return false
    }

    private fun canEquip(part: Part) : Boolean {
        return part.type == type
    }


}