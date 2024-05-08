package app.omnivore.omnivore.core.network.retrofit

import app.omnivore.omnivore.core.network.NetworkDataSource
import app.omnivore.omnivore.core.network.Networker
import app.omnivore.omnivore.core.network.model.AuthPayload
import app.omnivore.omnivore.core.network.model.EmailAuthPayload
import app.omnivore.omnivore.core.network.model.EmailLoginCredentials
import app.omnivore.omnivore.core.network.model.SignInParams
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
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
}

@Singleton
internal class RetrofitNetwork @Inject constructor(
    private val networkJson: Json,
    private val okhttpCallFactory: dagger.Lazy<Call.Factory>,
    private val networker: Networker
) : NetworkDataSource {

    private suspend fun getRetrofitInstance(): RetrofitNetworkApi = Retrofit.Builder()
            .baseUrl(networker.baseUrl())
            .callFactory { okhttpCallFactory.get().newCall(it) }
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(RetrofitNetworkApi::class.java)

    override suspend fun submitEmailLogin(credentials: EmailLoginCredentials): EmailAuthPayload =
        getRetrofitInstance().submitEmailLogin(credentials)

    override suspend fun submitAuthProviderLogin(params: SignInParams): AuthPayload =
        getRetrofitInstance().submitAuthProviderLogin(params)
}
