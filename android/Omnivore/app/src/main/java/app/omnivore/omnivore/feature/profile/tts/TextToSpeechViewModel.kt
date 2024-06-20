package app.omnivore.omnivore.feature.profile.tts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.omnivore.omnivore.core.datastore.DatastoreRepository
import app.omnivore.omnivore.core.datastore.PreferencesKeys
import app.omnivore.omnivore.core.datastore.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TextToSpeechViewModel @Inject constructor(
    private val datastoreRepository: DatastoreRepository
) : ViewModel() {

    val uiState: StateFlow<TextToSpeechUiState> = combine(
        selectedTopicId,
        getFollowableTopics(sortBy = TopicSortField.NAME),
        InterestsUiState::Interests,
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = InterestsUiState.Loading,
    )

    val userPreferencesState: StateFlow<UserPreferences> = datastoreRepository.userPreferencesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = UserPreferences(false, "")
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
}

sealed interface TextToSpeechUiState {
    data object Loading : TextToSpeechUiState

    data class Interests(
        val selectedTopicId: String?,
        val topics: List<FollowableTopic>,
    ) : TextToSpeechUiState

    data object Empty : TextToSpeechUiState
}
