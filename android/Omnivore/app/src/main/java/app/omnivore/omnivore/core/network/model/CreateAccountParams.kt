package app.omnivore.omnivore.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateAccountParams(
    val pendingUserToken: String,
    val userProfile: UserProfile
){
    @Serializable
    data class UserProfile(
        val username: String,
        val name: String
    )
}
