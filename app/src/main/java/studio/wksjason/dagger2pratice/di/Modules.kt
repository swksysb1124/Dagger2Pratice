package studio.wksjason.dagger2pratice.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import studio.wksjason.dagger2pratice.apiservice.AdvancedUserSelfDefinedApiService
import studio.wksjason.dagger2pratice.thirdparty.User3rdPartyDatabase
import studio.wksjason.dagger2pratice.apiservice.UserApiService
import studio.wksjason.dagger2pratice.database.UserDatabase
import javax.inject.Singleton

@Module
abstract class UserRemoteDataSourceModule {

    @Binds
    abstract fun provideUserApiService(
        advancedUserSelfDefinedApiService: AdvancedUserSelfDefinedApiService
    ): UserApiService

}

@Module
class UserLocalDataSourceModule {

    @Singleton
    @Provides
    fun provideUser3rdPartyDatabase(context: Context): UserDatabase =
        User3rdPartyDatabase.Builder(context)
            .name("user database")
            .size(1000)
            .build()
}

@Module
class ContextModule(private val context: Context) {

    @Provides
    fun getContext(): Context {
        return context
    }
}