package org.rak.scrappers.bot

import org.rak.scrappers.Resources
import org.rak.scrappers.State
import org.rak.scrappers.network.SimplifiedBot
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("bot")
class BotController {

    @GetMapping
    fun getBots(): List<SimplifiedBot> {
        return State.bots.values.map { SimplifiedBot(it) }
    }

    @GetMapping("/player")
    fun getPlayerBot(): SimplifiedBot {
        return SimplifiedBot(State.bot)
    }

    @GetMapping("/{id}")
    fun getBot(@PathVariable id: String): SimplifiedBot {
        return SimplifiedBot(State.bots[id] ?: throw ResponseStatusException(HttpStatus.NOT_FOUND))
    }

    @PutMapping("{id}/part")
    fun equipPart(@PathVariable botID: String, partId: String): SimplifiedBot {
        val bot = State.bots[botID] ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No bot found for $botID")
        val part = Resources.parts[partId] ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No bot found for $botID")
        bot.attemptEquip(part)

        return SimplifiedBot(bot)
    }

}