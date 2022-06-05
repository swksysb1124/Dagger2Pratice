package studio.wksjason.dagger2pratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userApiService = UserApiService()
        val userDatabase = UserDatabase()
        val userRemoteDataSource = UserRemoteDataSource(userApiService)
        val userLocalDataSource = UserLocalDataSource(userDatabase)
        userRepository = UserRepository(userLocalDataSource, userRemoteDataSource)
    }
}