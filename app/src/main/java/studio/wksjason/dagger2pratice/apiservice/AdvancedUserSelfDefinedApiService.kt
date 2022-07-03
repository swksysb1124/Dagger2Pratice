package studio.wksjason.dagger2pratice.apiservice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AdvancedUserSelfDefinedApiService @Inject constructor() : UserSelfDefinedApiService() {

    init {
        println("AdvancedUserSelfDefinedApiService object initialize")
    }

    override suspend fun getDataByApiCall(): String =
        withContext(Dispatchers.IO) {
            delay(200L)
            "data from advanced api service"
        }
}