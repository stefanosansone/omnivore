package app.omnivore.omnivore.core.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

// Keys
const val omnivoreSelfHostedApiServer =  "omnivoreSelfHostedAPIServer"
const val omnivoreSelfHostedWebServer = "omnivoreSelfHostedWebServer"
const val omnivoreAuthToken =  "omnivoreAuthToken"
const val omnivoreAuthCookieString =  "omnivoreAuthCookieString"
const val omnivorePendingUserToken =  "omnivorePendingUserToken"
const val libraryLastSyncTimestamp = "libraryLastSyncTimestamp"
const val preferredWebFontSize = "preferredWebFontSize"
const val preferredWebLineHeight = "preferredWebLineHeight"
const val preferredWebMaxWidthPercentage = "preferredWebMaxWidthPercentage"
const val preferredWebFontFamily = "preferredWebFontFamily"
const val prefersWebHighContrastText = "prefersWebHighContrastText"
const val prefersJustifyText = "prefersJustifyText"
const val lastUsedSavedItemFilter = "lastUsedSavedItemFilter"
const val lastUsedSavedItemSortFilter = "lastUsedSavedItemSortFilter"
const val preferredTheme = "preferredTheme"

object PreferencesKeys {
    val FOLLOWING_TAB_ACTIVE = booleanPreferencesKey("following_tab_active")
    val TTS_URV = booleanPreferencesKey("tts_urv")
    val TTS_ENGLISH_VOICE = stringPreferencesKey("tts_english_voice")
    val TTS_LANGUAGE = stringPreferencesKey("tts_language")
    val RTL_TEXT = booleanPreferencesKey("rtl_text")
    val VOLUME_ROCKER_FOR_SCROLL = booleanPreferencesKey("volume_rocker_for_scroll")
    val HIGH_CONTRAST_TEXT = booleanPreferencesKey("high_contrast_text")
}
