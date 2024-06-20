package app.omnivore.omnivore.core.network.model.speech

import kotlinx.serialization.Serializable

@Serializable
data class SpeechDocument(
    val pageId: String? = null,
    val wordCount: Double,
    val language: String,
    val defaultVoice: String,
    val utterances: List<Utterance>
) {
    companion object {
        const val averageWPM: Double = 195.0

        // This function simulates the URL generation
        fun audioDirectory(pageId: String): String {
            // Replace this with your actual documents directory path
            val documentsDirectory = "/path/to/documents"
            return "$documentsDirectory/audio-$pageId"
        }
    }

    fun estimatedDuration(utterance: Utterance, speed: Double): Double {
        return utterance.wordCount / averageWPM / speed * 60.0
    }

    fun audioDirectory(): String {
        return audioDirectory(pageId ?: "pageid")
    }
}
