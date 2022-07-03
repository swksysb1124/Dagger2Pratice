package studio.wksjason.dagger2pratice.apiservice

interface UserApiService {
    suspend fun getDataByApiCall(): String
}