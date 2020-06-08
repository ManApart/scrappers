package org.rak.scrappers.network

import org.rak.scrappers.Bot

class SimplifiedBot(val head: SimplifiedPart, val leftArm: SimplifiedPart, val rightArm: SimplifiedPart, val legs: SimplifiedPart) {
    constructor(bot: Bot) : this(SimplifiedPart(bot.head), SimplifiedPart(bot.leftArm), SimplifiedPart(bot.rightArm), SimplifiedPart(bot.legs))
}