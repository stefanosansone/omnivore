package app.omnivore.omnivore.feature.profile.filters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.omnivore.omnivore.core.datastore.DatastoreRepository
import app.omnivore.omnivore.core.datastore.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(
    private val datastoreRepository: DatastoreRepository
) : ViewModel() {

    val userPreferencesState: StateFlow<UserPreferences> = datastoreRepository.userPreferencesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = UserPreferences()
    )


    fun setFollowingTabActiveState(isFollowingTabActive: Boolean) {
        viewModelScope.launch {
            datastoreRepository.setFollowingTabActive(isFollowingTabActive)
        }
    }
}
