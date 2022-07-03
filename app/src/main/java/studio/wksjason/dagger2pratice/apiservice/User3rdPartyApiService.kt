package studio.wksjason.dagger2pratice.apiservice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import studio.wksjason.dagger2pratice.thirdparty.ApiClient3rdPartyLib

class User3rdPartyApiService(
    val apiClient3rdPartyLib: ApiClient3rdPartyLib
) : UserApiService {

    init {
        println("User3rdPartyApiService object initialize")
    }

    override suspend fun getDataByApiCall(): String =
        withContext(Dispatchers.IO) {
            delay(200L)
            "data from 3rd-party api service"
        }
}