package app.omnivore.omnivore.core.data.repository

import app.omnivore.omnivore.core.common.result.Result
import app.omnivore.omnivore.core.network.model.speech.SpeechDocument
import kotlinx.coroutines.flow.Flow

interface TextToSpeechRepository {
    suspend fun getSpeech(itemId: String): Flow<Result<SpeechDocument>>
}
