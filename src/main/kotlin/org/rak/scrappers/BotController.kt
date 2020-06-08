package org.rak.scrappers

import org.rak.scrappers.network.SimplifiedBot
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("bot")
class BotController {

    @GetMapping
    fun getBot(): SimplifiedBot {
        return SimplifiedBot(State.bot)
    }

    @PutMapping("/part")
    fun equipPart(partId: String): SimplifiedBot {
        val part = Resources.getPart(partId)
        if (part != null){
            State.bot.attemptEquip(part)
        }

        return getBot()
    }
}