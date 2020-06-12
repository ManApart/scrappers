package org.rak.scrappers.move

import com.fasterxml.jackson.annotation.JsonIgnore
import org.rak.scrappers.Resources
import org.rak.scrappers.effect.Effect

class Move(val id: String, val name: String, val cost: Int, val target: TargetType, val effectIds: List<String>) {
    private val effectList by lazy { effectIds.mapNotNull { Resources.effects[it] } }

    @JsonIgnore
    fun getEffects() : List<Effect> {
        return effectList
    }
}