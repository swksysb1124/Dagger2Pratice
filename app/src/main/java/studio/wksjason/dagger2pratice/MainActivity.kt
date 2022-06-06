package studio.wksjason.dagger2pratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection.inject
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userRepository2: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        val applicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()
        val userRepositoryComponent = DaggerUserRepositoryComponent.factory()
            .create(applicationComponent)
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