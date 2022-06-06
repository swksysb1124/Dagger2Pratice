package studio.wksjason.dagger2pratice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var userRepository: UserRepository

    init {
        val applicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(getApplication<Application>().applicationContext))
            .build()
        val userRepositoryComponent = DaggerUserRepositoryComponent.factory()
            .create(applicationComponent)
        userRepositoryComponent.inject(this)
    }

    class Factory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }
    }
}