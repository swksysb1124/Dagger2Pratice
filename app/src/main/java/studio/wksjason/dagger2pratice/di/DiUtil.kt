package studio.wksjason.dagger2pratice.di

import android.app.Application
import studio.wksjason.dagger2pratice.MainViewModel

object DiUtil {
    fun injectUseRepository(mainViewModel: MainViewModel) {
        val applicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(mainViewModel.getApplication<Application>().applicationContext))
            .build()
        val userRepositoryComponent = DaggerUserRepositoryComponent.factory()
            .create(applicationComponent)
        userRepositoryComponent.inject(mainViewModel)
    }
}