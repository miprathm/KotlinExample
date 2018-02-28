package prathm.com.kotlinexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import prathm.com.kotlinexample.databinding.RvItemRepositoryBinding

/**
 * Created by Prathm on 2/28/2018.
 */
public class RepositoryRecyclerViewAdapter(private var items : ArrayList<Repository>,
                                           private var listener : OnItemClickListener) :
        RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemRepositoryBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position],listener)

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun replaceData(arrayList:ArrayList<Repository>){
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding:RvItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo :Repository, listener: OnItemClickListener?){
            binding.repository = repo
            if(listener != null){
                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition)})
            }
            binding.executePendingBindings()
        }
    }
}