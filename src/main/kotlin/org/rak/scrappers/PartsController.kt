package org.rak.scrappers

import io.swagger.annotations.ApiModelProperty
import org.rak.scrappers.parts.Part
import org.rak.scrappers.parts.PartType
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.server.ResponseStatusException

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("part")
class PartsController {

    @GetMapping
    fun getPart(@RequestParam id: String): Part {
        return Resources.getPart(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/all")
    fun getParts(@RequestParam(required = false) type: PartType?): List<Part> {
        return Resources.getParts(type)
    }

}