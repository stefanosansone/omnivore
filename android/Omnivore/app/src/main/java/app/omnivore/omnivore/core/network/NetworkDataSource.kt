package app.omnivore.omnivore.core.network

import app.omnivore.omnivore.core.network.model.AuthPayload
import app.omnivore.omnivore.core.network.model.EmailAuthPayload
import app.omnivore.omnivore.core.network.model.EmailLoginCredentials
import app.omnivore.omnivore.core.network.model.SignInParams

interface NetworkDataSource {
    suspend fun submitEmailLogin(credentials: EmailLoginCredentials): EmailAuthPayload

    suspend fun submitAuthProviderLogin(params: SignInParams): AuthPayload
}
