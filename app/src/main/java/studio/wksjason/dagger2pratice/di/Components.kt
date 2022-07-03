package studio.wksjason.dagger2pratice.di

import dagger.Component
import studio.wksjason.dagger2pratice.*
import studio.wksjason.dagger2pratice.database.UserDatabase
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        UserLocalDataSourceModule::class,
        ContextModule::class
    ]
)
interface ApplicationComponent {
    fun provideUseDatabase(): UserDatabase
}

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [UserRemoteDataSourceModule::class]
)
interface UserRepositoryComponent {
    fun inject(mainViewModel: MainViewModel)

    @Component.Factory
    interface Factory {
        fun create(component: ApplicationComponent): UserRepositoryComponent
    }
}