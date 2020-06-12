package org.rak.scrappers.effect

import org.rak.scrappers.Resources
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("effect")
class EffectController {

    @GetMapping
    fun getEffects(): List<Effect> {
        return Resources.effects.values.toList()
    }

}