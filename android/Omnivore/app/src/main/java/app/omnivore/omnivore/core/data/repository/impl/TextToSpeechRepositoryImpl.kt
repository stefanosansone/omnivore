package app.omnivore.omnivore.core.data.repository.impl

import app.omnivore.omnivore.core.common.result.Result
import app.omnivore.omnivore.core.common.result.asResult
import app.omnivore.omnivore.core.data.repository.TextToSpeechRepository
import app.omnivore.omnivore.core.network.NetworkDataSource
import app.omnivore.omnivore.core.network.model.speech.SpeechDocument
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TextToSpeechRepositoryImpl @Inject constructor(
    private val dataSource: NetworkDataSource
): TextToSpeechRepository {
    override suspend fun getSpeech(itemId: String): Flow<Result<SpeechDocument>> =
        flow {
            emit(
                /*dataSource.getSpeech(
                    itemId = itemId
                )*/
                SpeechDocument(
                    pageId = "1",
                    language = "en-US",
                    wordCount = 100.0,
                    defaultVoice = "en-US-Wavenet-A",
                    utterances = emptyList()
                )
            )
        }.asResult()
}
