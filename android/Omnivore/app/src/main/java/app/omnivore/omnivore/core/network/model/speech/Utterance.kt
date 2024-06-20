package app.omnivore.omnivore.core.network.model.speech

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Serializable
data class Utterance(
    val idx: String,
    val text: String,
    val voice: String? = null,
    val wordOffset: Double,
    val wordCount: Double
) {
    @Serializable
    data class UtteranceRequest(
        val text: String,
        val voice: String,
        val language: String,
        val rate: String,
        val isUltraRealisticVoice: Boolean,
        val isOpenAIVoice: Boolean
    )

    fun toSSML(document: SpeechDocument): String {
        val usedVoice = voice ?: document.defaultVoice
        val request = UtteranceRequest(
            text = text,
            voice = usedVoice,
            language = document.language,
            rate = "1.1",
            isUltraRealisticVoice = Voices.isUltraRealisticVoice(usedVoice),
            isOpenAIVoice = Voices.isOpenAIVoice(usedVoice)
        )
        return Json.encodeToString(request)
    }
}
