package app.omnivore.omnivore.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class EmailAuthPayload(
    val authCookieString: String?,
    val authToken: String?,
    val pendingEmailVerification: Boolean?
)
