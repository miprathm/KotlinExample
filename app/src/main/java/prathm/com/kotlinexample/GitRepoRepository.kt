package prathm.com.kotlinexample

import android.os.Handler

/**
 * Created by Prathm on 2/27/2018.
 * Model Part in MVVM
 */

class GitRepoRepository {

    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({
            onDataReadyCallback.onDataReady("New Data")
        }, 2000)
    }

    fun getReositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Ownwer1", 1000, false))
        arrayList.add(Repository("Second", "Ownwer2", 1000, true))
        arrayList.add(Repository("Third", "Ownwer3", 1000, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onRepositoryReady(arrayList) }, 4000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data: String)
}

interface OnRepositoryReadyCallback {
    fun onRepositoryReady(data: ArrayList<Repository>)
}