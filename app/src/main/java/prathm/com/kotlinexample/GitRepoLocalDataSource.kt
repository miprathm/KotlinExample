package prathm.com.kotlinexample

import android.os.Handler

/**
 * Created by Prathm on 2/28/2018.
 */

class GitRepoLocalDataSource {

    fun getRepositories(onRepositoryReadyCallback: OnRepoLocalReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First From Local", "Owner 1", 100, false))
        arrayList.add(Repository("Second From Local", "Owner 2", 30, true))
        arrayList.add(Repository("Third From Local", "Owner 3", 430, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onLocalDataReady(arrayList) }, 2000)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>){
        //todo save repositories in DB
    }
}

interface OnRepoLocalReadyCallback {
    fun onLocalDataReady(data: ArrayList<Repository>)
}