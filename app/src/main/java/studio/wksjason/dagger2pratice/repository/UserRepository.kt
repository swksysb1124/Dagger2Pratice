package studio.wksjason.dagger2pratice.repository

import studio.wksjason.dagger2pratice.di.ViewModelScope
import studio.wksjason.dagger2pratice.datasource.UserLocalDataSource
import studio.wksjason.dagger2pratice.datasource.UserRemoteDataSource
import javax.inject.Inject

@ViewModelScope
class UserRepository @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend fun fetchDataFromRemote() =
        userRemoteDataSource.fetchDataFromApiService()
}



