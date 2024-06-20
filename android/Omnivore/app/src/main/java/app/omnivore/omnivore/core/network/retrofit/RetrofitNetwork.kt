package app.omnivore.omnivore.core.network.retrofit

import app.omnivore.omnivore.core.network.NetworkDataSource
import app.omnivore.omnivore.core.network.Networker
import app.omnivore.omnivore.core.network.model.AuthPayload
import app.omnivore.omnivore.core.network.model.CreateAccountParams
import app.omnivore.omnivore.core.network.model.EmailAuthPayload
import app.omnivore.omnivore.core.network.model.EmailLoginCredentials
import app.omnivore.omnivore.core.network.model.EmailSignUpParams
import app.omnivore.omnivore.core.network.model.PendingUserAuthPayload
import app.omnivore.omnivore.core.network.model.SignInParams
import app.omnivore.omnivore.core.network.model.speech.SpeechDocument
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
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

    @POST("/api/mobile-auth/create-account")
    suspend fun submitCreateAccount(
        @Body params: CreateAccountParams
    ): AuthPayload

    @POST("/api/mobile-auth/email-sign-up")
    suspend fun submitCreateEmailAccount(
        @Body params: EmailSignUpParams
    )

    @GET("/api/article/{itemID}/speech")
    suspend fun getSpeech(
        @Path("itemID") itemID: String,
        @Query("voice") currentVoice: String,
        @Query("secondaryVoice") secondaryVoice: String,
        @Query("priority") priority: String,
        @Query("language") language: String? = null
    ): SpeechDocument
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

    override suspend fun submitCreateAccount(createAccountParams: CreateAccountParams): AuthPayload =
        getRetrofitInstance().submitCreateAccount(createAccountParams)

    override suspend fun submitCreateEmailAccount(params: EmailSignUpParams) {
        getRetrofitInstance().submitCreateEmailAccount(params)
    }

    override suspend fun getSpeech(
        itemId: String,
        currentVoice: String,
        secondaryVoice: String,
        priority: String,
        language: String?
    ): SpeechDocument {
        return getRetrofitInstance().getSpeech(
            itemId,
            currentVoice,
            secondaryVoice,
            priority,
            language
        )
    }

}
