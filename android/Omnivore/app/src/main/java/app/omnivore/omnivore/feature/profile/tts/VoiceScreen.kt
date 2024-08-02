package app.omnivore.omnivore.feature.profile.tts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import app.omnivore.omnivore.R
import app.omnivore.omnivore.core.designsystem.component.PreferenceGroupHeader
import app.omnivore.omnivore.core.network.model.speech.VoiceItem
import app.omnivore.omnivore.core.network.model.speech.Voices
import app.omnivore.omnivore.core.network.model.speech.Voices.Pairs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun VoiceScreen(
    navController: NavHostController,
    languageKey: String?,
    viewModel: TextToSpeechViewModel = hiltViewModel()
) {

    val languages = remember { Voices.Languages }
    val voices = remember { Voices.Pairs }

    val uiState by viewModel.userPreferencesState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.tts_choose_a_voice)) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = null
                        )
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier.padding(contentPadding),
        ) {
            languages.find { it.key == languageKey }?.categories?.forEach { category ->
                item {
                    Column {
                        PreferenceGroupHeader(title = category.displayName)
                    }
                }
                val flatList = Pairs.flatMap {
                    listOf(
                        VoiceItem(name = it.firstName, category = it.category, key = it.firstKey, selected = false),
                        VoiceItem(name = it.secondName, category = it.category, key = it.secondKey, selected = false)
                    )
                }

                flatList.filter { it.category == category }.forEach {
                    item {
                        ListItem(
                            modifier = Modifier.clickable {
                                viewModel.setTtsVoice(it.name)
                            },
                            colors = ListItemDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.background
                            ),
                            headlineContent = { Text(it.name) },
                            trailingContent = {
                                if (uiState.englishVoice == it.name) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                    )
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}
