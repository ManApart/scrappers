package org.rak.scrappers.battle

import org.rak.scrappers.network.SimplifiedBattle
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("battle")
class BattleController {

    @GetMapping
    fun getBattle(): SimplifiedBattle {
        throw NotImplementedError()
    }

    @PostMapping("/move")
    fun useMove(moveId: String): SimplifiedBattle {
        throw NotImplementedError()
    }

}