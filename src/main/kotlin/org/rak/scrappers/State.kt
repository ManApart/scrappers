package org.rak.scrappers

import org.rak.scrappers.battle.Battle
import org.rak.scrappers.bot.Bot

object State {
    val bot = Bot("Starter Bot")
    val ownedParts = Resources.getParts().associate { it.id to 0 }.toMutableMap()
    var battle = Battle(bot, bot, true)


}