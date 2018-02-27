package prathm.com.kotlinexample

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import prathm.com.kotlinexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.repositoryName.text = "Modern Application"
        var repository = Repository("Modern","Prathm",1000,true)
        binding.apply {
            repositoryName.text = "Android Article"
            repositoryOwner.text = "Prathm"
            numberOfStarts.text="1000 stars"
        }

    }
}
