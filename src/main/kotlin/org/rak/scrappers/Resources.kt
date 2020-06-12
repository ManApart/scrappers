package org.rak.scrappers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.rak.scrappers.effect.Effect
import org.rak.scrappers.move.Move
import org.rak.scrappers.part.*
import org.rak.scrappers.wiring.JsonDirectoryParser

object Resources {
    private fun parseParts(path: String): List<Part> = jacksonObjectMapper().readValue(this::class.java.getResourceAsStream(path))
    private fun parseMoves(path: String): List<Move> = jacksonObjectMapper().readValue(this::class.java.getResourceAsStream(path))
    private fun parseEffects(path: String): List<Effect> = jacksonObjectMapper().readValue(this::class.java.getResourceAsStream(path))

    val parts = (listOf(DEFAULT_HEAD, DEFAULT_LEFT_ARM, DEFAULT_RIGHT_ARM, DEFAULT_LEGS) + loadParts() ).associateBy { it.id }
    val moves = loadMoves().associateBy { it.id }
    val effects = loadEffects().associateBy { it.id }

    private fun loadParts(): List<Part> {
        return JsonDirectoryParser.parseDirectory("/data/parts", ::parseParts).toMutableList().toList()
    }

    private fun loadMoves(): List<Move> {
        return JsonDirectoryParser.parseDirectory("/data/moves", ::parseMoves).toMutableList().toList()
    }

    private fun loadEffects(): List<Effect> {
        return JsonDirectoryParser.parseDirectory("/data/effects", ::parseEffects).toMutableList().toList()
    }

    private fun partListToMap(parts: List<Part>, type: PartType, defaultPart : Part) : Map<String, Part> {
        return parts.filter { it.type == type }.associateBy { it.id }.toMutableMap().apply { put(defaultPart.id, defaultPart) }.toMap()
    }

    fun getParts(type: PartType? = null): List<Part> {
        return if (type != null){
            parts.values.filter { it.type == type }.toList()
        } else {
            parts.values.toList()
        }
    }

}