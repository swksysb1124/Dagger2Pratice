package studio.wksjason.dagger2pratice.datasource

import studio.wksjason.dagger2pratice.apiservice.UserApiService
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val userApiService: UserApiService
) {
    suspend fun fetchDataFromApiService() =
        userApiService.getDataByApiCall()
}