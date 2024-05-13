package app.omnivore.omnivore.core.data.repository

import app.omnivore.omnivore.core.network.model.AuthPayload
import app.omnivore.omnivore.core.network.model.EmailAuthPayload
import app.omnivore.omnivore.core.network.model.EmailLoginCredentials
import app.omnivore.omnivore.core.network.model.SignInParams
import kotlinx.coroutines.flow.Flow
import app.omnivore.omnivore.core.common.result.Result
import app.omnivore.omnivore.core.network.model.PendingUserAuthPayload

interface AccountRepository {
    suspend fun submitEmailLogin(credentials: EmailLoginCredentials): Flow<Result<EmailAuthPayload>>
    suspend fun submitAuthProviderLogin(params: SignInParams): Flow<Result<AuthPayload>>
    suspend fun submitPendingUser(params: SignInParams): Flow<Result<PendingUserAuthPayload>>
}
