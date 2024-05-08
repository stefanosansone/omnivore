package app.omnivore.omnivore.di

import app.omnivore.omnivore.core.network.NetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkModule {

    @Binds
    fun binds(impl: NetworkDataSource): NetworkDataSource
}
