package prathm.com.kotlinexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import prathm.com.kotlinexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {

    override fun onItemClick(position: Int) {
        Log.d(localClassName,"Hello")
    }

    lateinit var binding : ActivityMainBinding
    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(),this)
    //var mainViewModel = MainViewModel()

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

        //binding.viewModel = mainViewModel

        val viewModel= ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        binding.executePendingBindings()


        binding.repositoryRv.layoutManager = LinearLayoutManager(this)

        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this,Observer<ArrayList<Repository>>{ it?.let { repositoryRecyclerViewAdapter.replaceData(it) } })

    }
}
