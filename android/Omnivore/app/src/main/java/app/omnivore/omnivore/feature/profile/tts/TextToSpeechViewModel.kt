package app.omnivore.omnivore.feature.profile.tts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.omnivore.omnivore.core.datastore.DatastoreRepository
import app.omnivore.omnivore.core.datastore.UserPreferences
import app.omnivore.omnivore.core.network.model.speech.VoiceLanguage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TextToSpeechViewModel @Inject constructor(
    private val datastoreRepository: DatastoreRepository
) : ViewModel() {


/*    val uiState: StateFlow<TextToSpeechUiState> = a.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = TextToSpeechUiState.Loading,
    )*/

    val userPreferencesState: StateFlow<UserPreferences> = datastoreRepository.userPreferencesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = UserPreferences()
    )

    fun setUseUltraRealisticVoices(useUrv: Boolean) {
        viewModelScope.launch {
            datastoreRepository.updateUseUltraRealisticVoices(useUrv)
        }
    }

    fun setTtsVoice(voice: String) {
        viewModelScope.launch {
            datastoreRepository.updateEnglishVoice(voice)
        }
    }

    fun setTtsLanguage(language: String) {
        viewModelScope.launch {
            datastoreRepository.setDefaultTtsLanguage(language)
        }
    }
}

sealed interface TextToSpeechUiState {
    data class Success(val ttsLanguage: String) : TextToSpeechUiState
    data object Error : TextToSpeechUiState
    data object Loading : TextToSpeechUiState
}
