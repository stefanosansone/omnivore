package app.omnivore.omnivore.core.network.retrofit

import app.omnivore.omnivore.core.network.Networker
import app.omnivore.omnivore.core.network.model.AuthPayload
import app.omnivore.omnivore.core.network.model.CreateAccountParams
import app.omnivore.omnivore.core.network.model.EmailSignUpParams
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CreateAccountSubmit {
    @Headers("Content-Type: application/json")
    @POST("/api/mobile-auth/create-account")
    suspend fun submitCreateAccount(@Body params: CreateAccountParams): Response<AuthPayload>
}

interface CreateEmailAccountSubmit {
    @Headers("Content-Type: application/json")
    @POST("/api/mobile-auth/email-sign-up")
    suspend fun submitCreateEmailAccount(@Body params: EmailSignUpParams): Response<Unit>
}

object RetrofitHelper {
    suspend fun getInstance(networker: Networker): Retrofit {
        val baseUrl = networker.baseUrl()
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}
