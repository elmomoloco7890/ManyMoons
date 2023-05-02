package com.artemis.manymoons
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemis.manymoons.databinding.MoonItemsBinding
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class MoonListAdapter(
    private val context: Context,
    options: FirebaseRecyclerOptions<MoonMenuX>,
    private val moonItemsListener: MoonItemClickListener
): FirebaseRecyclerAdapter<MoonMenuX, MoonListAdapter.MoonMenuViewHolder?>(options){

    private lateinit var binding: MoonItemsBinding

    class MoonMenuViewHolder(private var moonItems: MoonItemsBinding): RecyclerView.ViewHolder(moonItems.root){
        fun bind(currentItem: MoonMenuX, listener: MoonItemClickListener){
            moonItems.moonMenuX = currentItem
            moonItems.moonItemClicked = listener
            moonItems.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoonMenuViewHolder {
        val inflater = LayoutInflater.from(context)
        val moonBinding = MoonItemsBinding.inflate(inflater, parent, false)
        binding = moonBinding
        return MoonMenuViewHolder(moonBinding)
    }

    override fun onBindViewHolder(holder: MoonMenuViewHolder, position: Int, model: MoonMenuX) =
        holder.bind(model, moonItemsListener)

}