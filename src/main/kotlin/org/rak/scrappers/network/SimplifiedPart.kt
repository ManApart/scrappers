package org.rak.scrappers.network

import org.rak.scrappers.PartSlot
import org.rak.scrappers.parts.Part

data class SimplifiedPart(val id: String, val health: Int){
    constructor(part: Part) : this(part.id, part.health)
    constructor(slot: PartSlot) : this(slot.part.id, slot.part.health)
}