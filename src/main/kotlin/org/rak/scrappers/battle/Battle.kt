package org.rak.scrappers.battle

import org.rak.scrappers.bot.Bot
import org.rak.scrappers.move.Move

class Battle(val playerBot: Bot, val enemyBot: Bot, var complete: Boolean = false) {
    val log = mutableListOf<BattleLogEntry>()



    fun executeMove(bot: Bot, move: Move) {
        //if bot can execute
        //add effects, remove energy etc
        log.add(BattleLogEntry(bot.id, move.id))
    }

}