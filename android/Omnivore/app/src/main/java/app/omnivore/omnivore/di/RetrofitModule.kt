package app.omnivore.omnivore.di

import app.omnivore.omnivore.core.network.NetworkDataSource
import app.omnivore.omnivore.core.network.retrofit.RetrofitNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RetrofitModule {

    @Binds
    fun binds(impl: RetrofitNetwork): NetworkDataSource
}
