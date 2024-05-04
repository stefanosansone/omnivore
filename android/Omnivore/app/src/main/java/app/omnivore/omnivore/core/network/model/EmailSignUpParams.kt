package app.omnivore.omnivore.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class EmailSignUpParams(
    val email: String,
    val password: String,
    val username: String,
    val name: String
)
