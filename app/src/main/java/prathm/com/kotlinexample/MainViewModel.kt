package prathm.com.kotlinexample

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * Created by Prathm on 2/27/2018.
 */
class MainViewModel : ViewModel() {
    var repoModel : RepoModel = RepoModel()
    //var text : String =""
    //var isLoading : Boolean = false
    val text = ObservableField<String>()
    val isLoading = ObservableField<Boolean>()

    val onDataReadyCallback = object : OnDataReadyCallback{
        override fun onDataReady(data: String) {
            isLoading.set(false)
            text.set(data)

        }
    }

    fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(onDataReadyCallback)
    }
}