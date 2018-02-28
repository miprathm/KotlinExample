package prathm.com.kotlinexample

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Prathm on 2/28/2018.
 */
class NetManager(private var applicationContext: Context) {
    private var status: Boolean? = false

    val isConnectedToInternet: Boolean?
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val ni = conManager.activeNetworkInfo
            return ni != null && ni.isConnected
        }
}