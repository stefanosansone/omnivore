package app.omnivore.omnivore.core.network

import app.omnivore.omnivore.core.network.model.AuthPayload
import app.omnivore.omnivore.core.network.model.CreateAccountParams
import app.omnivore.omnivore.core.network.model.EmailAuthPayload
import app.omnivore.omnivore.core.network.model.EmailLoginCredentials
import app.omnivore.omnivore.core.network.model.EmailSignUpParams
import app.omnivore.omnivore.core.network.model.PendingUserAuthPayload
import app.omnivore.omnivore.core.network.model.SignInParams

interface NetworkDataSource {
    suspend fun submitEmailLogin(credentials: EmailLoginCredentials): EmailAuthPayload

    suspend fun submitAuthProviderLogin(params: SignInParams): AuthPayload

    suspend fun submitPendingUser(params: SignInParams): PendingUserAuthPayload

    suspend fun submitCreateAccount(createAccountParams: CreateAccountParams): AuthPayload

    suspend fun submitCreateEmailAccount(params: EmailSignUpParams)
}
