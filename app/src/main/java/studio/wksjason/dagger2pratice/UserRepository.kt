package studio.wksjason.dagger2pratice

import dagger.Component
import javax.inject.Inject

@Component
interface UserRepositoryComponent {
    fun getUserRepository() : UserRepository
}

class UserRepository @Inject constructor(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource
) {

}

class UserLocalDataSource @Inject constructor(val userDatabase: UserDatabase) {

}

class UserRemoteDataSource @Inject constructor(val userApiService: UserApiService) {

}

class UserApiService @Inject constructor() {

}

class UserDatabase @Inject constructor() {

}