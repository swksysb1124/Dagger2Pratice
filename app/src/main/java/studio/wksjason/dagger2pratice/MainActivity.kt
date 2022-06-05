package studio.wksjason.dagger2pratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerUserRepositoryComponent.create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}