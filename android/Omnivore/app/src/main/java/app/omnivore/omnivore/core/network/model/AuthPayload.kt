package app.omnivore.omnivore.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthPayload(
    val authCookieString: String,
    val authToken: String
)
