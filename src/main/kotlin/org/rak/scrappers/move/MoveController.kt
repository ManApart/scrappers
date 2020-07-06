package org.rak.scrappers.move

import org.rak.scrappers.Resources
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("move")
class MoveController {

    @GetMapping
    fun getMoves(): List<Move> {
        return Resources.moves.values.toList()
    }

}