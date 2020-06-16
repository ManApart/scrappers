package org.rak.scrappers.bot

import org.rak.scrappers.Resources
import org.rak.scrappers.State
import org.rak.scrappers.network.EquipResponse
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
    fun equipPart(partId: String): EquipResponse {
        var success = false
        val part = Resources.parts[partId]
        if (part != null){
            success = State.bot.attemptEquip(part)
        }

        return EquipResponse(success, getBot())
    }

}