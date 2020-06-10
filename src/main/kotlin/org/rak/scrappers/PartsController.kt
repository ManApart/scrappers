package org.rak.scrappers

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.rak.scrappers.parts.Part
import org.rak.scrappers.parts.PartType
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("part")
@Api(description = "Get Bot Parts")
class PartsController {

    @GetMapping("/{id}")
    fun getPart(@PathVariable("id") id: String): Part {
        return Resources.getPart(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun getParts(@ApiParam("Optionally only get parts of this type.") @RequestParam(required = false) type: PartType?): List<Part> {
        return Resources.getParts(type)
    }

    @GetMapping("/owned")
    @ApiOperation("Return the id and count of any owned parts.")
    fun getOwnedParts(@RequestParam(required = false) type: PartType?): Map<String, Int> {
        return Resources.getOwnedParts(type)
    }

}