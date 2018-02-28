package prathm.com.kotlinexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * Created by Prathm on 2/27/2018.
 */
class MainViewModel : ViewModel() {
    var repoModel : GitRepoRepository = GitRepoRepository()
    //var text : String =""
    //var isLoading : Boolean = false
    val text = ObservableField<String>()
    val isLoading = ObservableField<Boolean>()
    var repositories = MutableLiveData<ArrayList<Repository>>()

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

    fun loadRepositories(){
        isLoading.set(true)
        repoModel.getReositories(object : OnRepositoryReadyCallback{
            override fun onRepositoryReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}