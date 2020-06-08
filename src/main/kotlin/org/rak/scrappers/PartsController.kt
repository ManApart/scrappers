package org.rak.scrappers

import org.rak.scrappers.parts.Part
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("part")
class PartsController {

    @GetMapping("/head")
    fun getHeads(): List<Part> {
        return Resources.heads.values.toList()
    }

    @GetMapping("/arm")
    fun getArms(): List<Part> {
        return Resources.arms.values.toList()
    }

    @GetMapping("/leg")
    fun getLegs(): List<Part> {
        return Resources.legs.values.toList()
    }
}