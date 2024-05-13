package app.omnivore.omnivore.core.network.retrofit

import app.omnivore.omnivore.core.network.NetworkDataSource
import app.omnivore.omnivore.core.network.Networker
import app.omnivore.omnivore.core.network.model.AuthPayload
import app.omnivore.omnivore.core.network.model.EmailAuthPayload
import app.omnivore.omnivore.core.network.model.EmailLoginCredentials
import app.omnivore.omnivore.core.network.model.PendingUserAuthPayload
import app.omnivore.omnivore.core.network.model.SignInParams
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

interface RetrofitNetworkApi {

    @POST("/api/mobile-auth/email-sign-in")
    suspend fun submitEmailLogin(
        @Body credentials: EmailLoginCredentials
    ): EmailAuthPayload

    @POST("/api/mobile-auth/sign-in")
    suspend fun submitAuthProviderLogin(
        @Body params: SignInParams
    ): AuthPayload

    @POST("/api/mobile-auth/sign-up")
    suspend fun submitPendingUser(
        @Body params: SignInParams
    ): PendingUserAuthPayload
}

@Singleton
internal class RetrofitNetwork @Inject constructor(
    private val networker: Networker
) : NetworkDataSource {

    private suspend fun getRetrofitInstance(): RetrofitNetworkApi = Retrofit.Builder()
            .baseUrl(networker.baseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitNetworkApi::class.java)

    override suspend fun submitEmailLogin(credentials: EmailLoginCredentials): EmailAuthPayload =
        getRetrofitInstance().submitEmailLogin(credentials)

    override suspend fun submitAuthProviderLogin(params: SignInParams): AuthPayload =
        getRetrofitInstance().submitAuthProviderLogin(params)

    override suspend fun submitPendingUser(params: SignInParams): PendingUserAuthPayload =
        getRetrofitInstance().submitPendingUser(params)
}
