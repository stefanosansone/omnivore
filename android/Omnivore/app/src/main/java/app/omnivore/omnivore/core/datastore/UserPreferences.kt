package app.omnivore.omnivore.core.datastore

data class UserPreferences(
    val followingTabActive: Boolean = false,
    val ttsUrv: Boolean = false,
    val englishVoice: String = "",
    val ttsLanguage: String = "",
    val rtlText: Boolean = false,
    val volumeForScroll: Boolean = false,
    val highContrastText: Boolean = false
)
