package org.rak.scrappers.battle

import org.rak.scrappers.State
import org.rak.scrappers.network.SimplifiedBattle
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("battle")
class BattleController {

    @GetMapping
    fun getBattle(): SimplifiedBattle {
        return SimplifiedBattle(State.battle)
    }

    @PostMapping
    fun startBattle(@RequestParam enemyBotId: String): SimplifiedBattle {
        val enemy = State.bots[enemyBotId]
        if (enemy != null) {
            State.battle = Battle(State.bot, enemy)
            return SimplifiedBattle(State.battle)
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/move")
    fun useMove(moveId: String): SimplifiedBattle {
        val move = State.bot.getMove(moveId)
        if (move != null) {
            State.battle.executeMove(State.bot, move)
        }
        return SimplifiedBattle(State.battle)
    }

}