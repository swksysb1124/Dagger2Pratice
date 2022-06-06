package studio.wksjason.dagger2pratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userRepository2: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        val baseComponent = DaggerApplicationComponent.create()
        val userRepositoryComponent = baseComponent.userRepositoryComponent().create()
        userRepositoryComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(
            "user api service instance equals? " +
                    "${
                        userRepository.userRemoteDataSource.userApiService ===
                                userRepository2.userRemoteDataSource.userApiService
                    }"
        )
    }
}