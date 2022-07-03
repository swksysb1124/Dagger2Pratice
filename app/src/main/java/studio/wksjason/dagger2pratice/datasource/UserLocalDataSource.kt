package studio.wksjason.dagger2pratice.datasource

import studio.wksjason.dagger2pratice.database.UserDatabase
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val userDatabase: UserDatabase
) {

}