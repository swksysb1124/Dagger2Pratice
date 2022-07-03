package studio.wksjason.dagger2pratice

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import studio.wksjason.dagger2pratice.di.DiUtil
import studio.wksjason.dagger2pratice.repository.UserRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

class MainViewModel(
    application: Application
) : AndroidViewModel(application) {

    init {
        DiUtil.injectUseRepository(this)
    }

    @Inject
    lateinit var userRepository: UserRepository

    sealed class MainViewState {
        data class UpdateData(val data: String) : MainViewState()
    }

    private val _viewState = MutableLiveData<MainViewState>()
    val viewSate: LiveData<MainViewState> = _viewState

    fun fetchData() {
        viewModelScope.launch(Dispatchers.Main) {
            val data = userRepository.fetchDataFromRemote()
            _viewState.value = MainViewState.UpdateData(data)
        }
    }

    class Factory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application) as? T ?: throw IllegalArgumentException("Wrong ")
        }
    }
}