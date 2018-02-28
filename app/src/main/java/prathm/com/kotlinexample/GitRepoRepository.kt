package prathm.com.kotlinexample

import android.os.Handler

/**
 * Created by Prathm on 2/27/2018.
 * Model Part in MVVM
 */

class GitRepoRepository {

    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        remoteDataSource.getRepositories( object : OnRepoRemoteReadyCallback {
            override fun onRemoteDataReady(data: ArrayList<Repository>) {
                localDataSource.saveRepositories(data)
                onRepositoryReadyCallback.onDataReady(data)
            }


        })
    }
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}