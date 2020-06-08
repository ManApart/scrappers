package org.rak.scrappers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.rak.scrappers.parts.*

object Resources {
    private fun parseFile(path: String): List<Part> = jacksonObjectMapper().readValue(this::class.java.getResourceAsStream(path))
    private val parts = loadParts()

    val heads = partListToMap(parts, PartType.HEAD, DEFAULT_HEAD)
    val leftArms = partListToMap(parts, PartType.LEFT_ARM, DEFAULT_LEFT_ARM)
    val rightArms = partListToMap(parts, PartType.RIGHT_ARM, DEFAULT_RIGHT_ARM)
    val legs = partListToMap(parts, PartType.LEGS, DEFAULT_LEGS)


    private fun loadParts(): List<Part> {
        return JsonDirectoryParser.parseDirectory("/data/parts", ::parseFile).toMutableList().toList()
    }

    private fun partListToMap(parts: List<Part>, type: PartType, defaultPart : Part) : Map<String, Part> {
        return parts.filter { it.type == type }.associateBy { it.id }.toMutableMap().apply { put(defaultPart.id, defaultPart) }.toMap()
    }

    fun getPart(partId: String): Part? {
        return heads[partId] ?: leftArms[partId] ?: rightArms[partId] ?: legs[partId]
    }

    fun getParts(type: PartType?): List<Part> {
        return when (type) {
            PartType.HEAD -> heads.values.toList()
            PartType.RIGHT_ARM -> rightArms.values.toList()
            PartType.LEFT_ARM -> leftArms.values.toList()
            PartType.LEGS -> legs.values.toList()
            else -> (heads.values + leftArms.values + rightArms.values + legs.values).toList()
        }
    }

}