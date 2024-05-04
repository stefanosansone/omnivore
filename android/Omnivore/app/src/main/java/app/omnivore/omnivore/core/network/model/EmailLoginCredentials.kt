package app.omnivore.omnivore.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class EmailLoginCredentials(
    val email: String,
    val password: String
)
