package org.rak.scrappers

object JsonDirectoryParser {

    fun <E> parseDirectory(directoryPath: String, parser: (path: String) -> List<E>): List<E> {
        val helper = KotlinResourceHelper()
        return helper.getResourceFiles(directoryPath).map {
            parser(it)
        }.flatten()
    }

}