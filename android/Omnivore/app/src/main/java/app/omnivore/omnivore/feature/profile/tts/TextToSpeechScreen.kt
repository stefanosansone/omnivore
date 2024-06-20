package app.omnivore.omnivore.feature.profile.tts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import app.omnivore.omnivore.R
import app.omnivore.omnivore.core.designsystem.component.PreferenceGroupHeader
import app.omnivore.omnivore.core.designsystem.component.TextPreferenceWidget
import app.omnivore.omnivore.core.network.model.speech.Voices
import app.omnivore.omnivore.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TextToSpeechScreen(
    navController: NavHostController,
    textToSpeechViewModel: TextToSpeechViewModel = hiltViewModel()
) {

    val langs = remember { Voices.Languages }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.profile_text_to_speech)) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = null
                        )
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
            )
        },
    ) { contentPadding ->
        LazyColumn(
            contentPadding = contentPadding,
        ) {
            item {
                TextPreferenceWidget(
                    title = stringResource(R.string.tts_voices),
                    onPreferenceClick = { navController.navigate(Routes.Voices.route) },
                )
            }
        }
    }
}
