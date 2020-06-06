package org.rak.scrappers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScrappersApplication

fun main(args: Array<String>) {
	runApplication<ScrappersApplication>(*args)
}
