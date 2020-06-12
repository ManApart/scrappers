package org.rak.scrappers

import org.rak.scrappers.bot.Bot

object State {
    val bot = Bot("Starter Bot")
    val ownedParts = Resources.getParts().associate { it.id to 0 }.toMutableMap()


}