package studio.wksjason.dagger2pratice.apiservice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class UserSelfDefinedApiService @Inject constructor() : UserApiService {

    init {
        println("UserSelfDefinedApiService object initialize")
    }

    override suspend fun getDataByApiCall(): String =
        withContext(Dispatchers.IO) {
            delay(200L)
            "data from self defined api service"
        }

}