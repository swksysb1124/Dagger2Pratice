package studio.wksjason.dagger2pratice

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Component(modules = [UserRemoteDataSourceModule::class, UserLocalDataSourceModule::class])
interface UserRepositoryComponent {
    fun inject(activity: MainActivity)
}

class UserRepository @Inject constructor(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource
) {

}

@Module
abstract class UserRemoteDataSourceModule {

    @Binds
    abstract fun provideUserApiService(advancedUserSelfDefinedApiService: AdvancedUserSelfDefinedApiService): UserApiService
}

@Module
class UserLocalDataSourceModule {

    @Provides
    fun provideUser3rdPartyDatabase(): UserDatabase = User3rdPartyDatabase.Builder()
        .name("user database")
        .size(1000)
        .build()
}


class UserLocalDataSource @Inject constructor(val userDatabase: UserDatabase) {

}

class UserRemoteDataSource @Inject constructor(val userApiService: UserApiService) {

}

interface UserApiService {

}

class AdvancedUserSelfDefinedApiService @Inject constructor() : UserSelfDefinedApiService() {
    init {
        println("AdvancedUserSelfDefinedApiService object initialize")
    }
}

open class UserSelfDefinedApiService @Inject constructor() : UserApiService {
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

interface UserDatabase {

}

class User3rdPartyDatabase(builder: Builder) : UserDatabase {

    init {
        println("User3rdPartyDatabase object initialize")
    }

    val name: String?
    val size: Int?

    init {
        this.name = builder.name
        this.size = builder.size
    }

    class Builder {
        var name: String? = null
            private set
        var size: Int? = null
            private set

        fun name(name: String) = apply { this.name = name }
        fun size(size: Int) = apply { this.size = size }
        fun build() = User3rdPartyDatabase(this)
    }
}

