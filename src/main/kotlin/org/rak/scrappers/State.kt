package org.rak.scrappers

import org.rak.scrappers.battle.Battle
import org.rak.scrappers.bot.Bot

object State {
    val bot = Bot("player_bot","Starter Bot")
    val bots = listOf(bot).associateBy { it.id }
    val ownedParts = Resources.getParts().associate { it.id to 0 }.toMutableMap()
    var battle = Battle(bot, bot, true)


}