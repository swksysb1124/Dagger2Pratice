package studio.wksjason.dagger2pratice

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Component(modules = [UserRemoteDataSourceModule::class])
interface UserRepositoryComponent {
    fun inject(activity: MainActivity)
}

class UserRepository @Inject constructor(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource
) {

}

@Module
class UserRemoteDataSourceModule {

    @Provides
    fun provideUserApiService(apiClient3rdPartyLib: ApiClient3rdPartyLib): UserApiService =
        User3rdPartyApiService(apiClient3rdPartyLib)

    @Provides
    fun provide3rdPartyLib(): ApiClient3rdPartyLib = ApiClient3rdPartyLib()
}


class UserLocalDataSource @Inject constructor(val userDatabase: UserDatabase) {

}

class UserRemoteDataSource @Inject constructor(val userApiService: UserApiService) {

}

interface UserApiService {

}

class UserSelfDefinedApiService : UserApiService {
    init {
        println("UserSelfDefinedApiService object initialize")
    }
}

class User3rdPartyApiService(val apiClient3rdPartyLib: ApiClient3rdPartyLib) : UserApiService {
    init {
        println("User3rdPartyApiService object initialize")
    }
}

class ApiClient3rdPartyLib {
    init {
        println("ApiClient3rdPartyLib object initialize")
    }
}

class UserDatabase @Inject constructor() {

}