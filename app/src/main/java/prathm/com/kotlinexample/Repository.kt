package prathm.com.kotlinexample

import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * Created by Prathm on 2/27/2018.
 */

class Repository( repositoryName : String?,
                  var repositoryOwner: String?,
                  var numberOfStars : Int? ,
                  var hasIssues : Boolean = false) : BaseObservable(){


    @get:Bindable
    var repositoryName : String = "AAAA"
    set(value) {
        field = value
        notifyPropertyChanged(BR.repositoryName)
    }

}