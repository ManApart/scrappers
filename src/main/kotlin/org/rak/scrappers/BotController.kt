package org.rak.scrappers

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("bot")
class BotController {

    @GetMapping
    fun getBot(): Bot {
        return State.bot
    }

    @PutMapping("/part")
    fun equipPart(partId: String): Bot {
        val part = Resources.getPart(partId)
        if (part != null){
            State.bot.attemptEquip(part)
        }

        return State.bot
    }
}