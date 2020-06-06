package org.rak.scrappers

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
class BotController {

    @GetMapping("/bot")
    fun getBot(): Bot {
        return State.bot
    }
}