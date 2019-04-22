package ru.example.ivan.ulikirostov

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.example.ivan.ulikirostov.databinding.ItemRvMainBinding
import ru.example.ivan.ulikirostov.databinding.ItemRvResultBinding

class ResultRecyclerViewAdapter(private var items: ArrayList<Item>,
                                private var listener: OnItemClickListener)
    : RecyclerView.Adapter<ResultRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRvResultBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData(arrayList: ArrayList<Item>) {
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: ItemRvResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, listener: OnItemClickListener?) {
            binding.item = item
            if (listener != null) {
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition) }
            }
        }
    }
}