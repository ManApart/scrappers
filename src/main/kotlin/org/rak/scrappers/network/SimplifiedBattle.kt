package org.rak.scrappers.network

import org.rak.scrappers.battle.Battle
import org.rak.scrappers.battle.BattleLogEntry

class SimplifiedBattle(val playerBot: SimplifiedBot, val enemyBot: SimplifiedBot, val log: List<BattleLogEntry> = listOf()) {
    constructor(battle: Battle): this(SimplifiedBot(battle.playerBot), SimplifiedBot(battle.enemyBot), battle.log)
}