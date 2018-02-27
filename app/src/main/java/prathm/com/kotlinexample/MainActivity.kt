package prathm.com.kotlinexample

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import prathm.com.kotlinexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    var mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)

        //binding.repositoryName.text = "Modern Application"
        var repository = Repository("Modern","Prathm",1000,true)
        //binding.repository = repository
        //binding.executePendingBindings()
        /*binding.apply {
            repositoryName.text = "Android Article"
            repositoryOwner.text = "Prathm"
            numberOfStarts.text="1000 stars"
        }

        Handler().postDelayed({
        repository.repositoryName = "ASDF"
        },2000)
        */

        binding.viewModel = mainViewModel
        binding.executePendingBindings()


    }
}
