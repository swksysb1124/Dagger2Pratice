package studio.wksjason.dagger2pratice

class UserRepository(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource
) {

}

class UserLocalDataSource(val userDatabase: UserDatabase) {

}

class UserRemoteDataSource(val userApiService: UserApiService) {

}

class UserApiService() {

}

class UserDatabase() {

}