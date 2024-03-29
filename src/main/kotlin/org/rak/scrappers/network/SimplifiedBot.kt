package org.rak.scrappers.network

import org.rak.scrappers.bot.Bot

class SimplifiedBot(val id: String, val name: String, val head: SimplifiedPart, val leftArm: SimplifiedPart, val rightArm: SimplifiedPart, val legs: SimplifiedPart) {
    constructor(bot: Bot) : this(bot.id, bot.name, SimplifiedPart(bot.head), SimplifiedPart(bot.leftArm), SimplifiedPart(bot.rightArm), SimplifiedPart(bot.legs))
}