package studio.wksjason.dagger2pratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.Factory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.fetchData()

        mainViewModel.viewSate.observe(this) { viewState ->
            when (viewState) {
                is MainViewModel.MainViewState.UpdateData -> {
                    Toast.makeText(this@MainActivity, viewState.data, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}