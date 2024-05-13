package app.omnivore.omnivore.core.data.repository.impl

import app.omnivore.omnivore.core.common.result.Result
import app.omnivore.omnivore.core.common.result.asResult
import app.omnivore.omnivore.core.data.repository.AccountRepository
import app.omnivore.omnivore.core.network.NetworkDataSource
import app.omnivore.omnivore.core.network.model.AuthPayload
import app.omnivore.omnivore.core.network.model.EmailAuthPayload
import app.omnivore.omnivore.core.network.model.EmailLoginCredentials
import app.omnivore.omnivore.core.network.model.PendingUserAuthPayload
import app.omnivore.omnivore.core.network.model.SignInParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val dataSource: NetworkDataSource
) : AccountRepository {
    override suspend fun submitEmailLogin(credentials: EmailLoginCredentials): Flow<Result<EmailAuthPayload>> =
        flow {
            emit(dataSource.submitEmailLogin(credentials))
        }.asResult()

    override suspend fun submitAuthProviderLogin(params: SignInParams): Flow<Result<AuthPayload>> =
        flow {
            emit(dataSource.submitAuthProviderLogin(params))
        }.asResult()

    override suspend fun submitPendingUser(params: SignInParams): Flow<Result<PendingUserAuthPayload>> =
        flow {
            emit(dataSource.submitPendingUser(params))
        }.asResult()
}
