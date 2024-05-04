package app.omnivore.omnivore.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class SignInParams(
    val token: String,
    val provider: String, // APPLE or GOOGLE
    val source: String = "ANDROID"
)
