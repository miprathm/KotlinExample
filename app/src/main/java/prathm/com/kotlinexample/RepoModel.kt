package prathm.com.kotlinexample

import android.os.Handler

/**
 * Created by Prathm on 2/27/2018.
 * Model Part in MVVM
 */

class RepoModel{

    fun refreshData(onDataReadyCallback: OnDataReadyCallback){
        Handler().postDelayed({
            onDataReadyCallback.onDataReady("New Data")
        },2000)
    }

}

interface OnDataReadyCallback{
    fun onDataReady(data: String)
}