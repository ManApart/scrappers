package org.rak.scrappers

import org.rak.scrappers.parts.*

object Resources {

    val heads = mapOf(DEFAULT_HEAD.id to DEFAULT_HEAD)
    val arms = mapOf(DEFAULT_RIGHT_ARM.id to DEFAULT_RIGHT_ARM, DEFAULT_LEFT_ARM.id to DEFAULT_LEFT_ARM)
    val legs = mapOf(DEFAULT_LEGS.id to DEFAULT_LEGS)

    fun getPart(partId: String) : Part? {
        return heads[partId] ?: arms[partId] ?: legs[partId]
    }

}