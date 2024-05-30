package com.rhiquest.mohnuriskiakbar_codingtestapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rhiquest.mohnuriskiakbar_codingtestapp.databinding.ItemListBinding
import com.rhiquest.mohnuriskiakbar_codingtestapp.response.ResponseGetAllItem
import com.rhiquest.mohnuriskiakbar_codingtestapp.response.ResponseGetAllItemItem

class ItemsAdapter(private val item: List<ResponseGetAllItemItem>):
    RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemsAdapter.ItemsViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(view)
    }

    class ItemsViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(items: ResponseGetAllItemItem){
            binding.itemUserid.text = items.userId.toString()
            binding.itemTitle.text = items.title

            binding.tvclick.setOnClickListener {
                val bundle =  Bundle()
                bundle.putString("id", items.id.toString())
                binding.root.context.startActivity(Intent(binding.root.context, ActivityB::class.java).putExtras(bundle))
            }
        }
    }

    override fun onBindViewHolder(holder: ItemsAdapter.ItemsViewHolder, position: Int) {
        holder.bindData(item[position])
    }

    override fun getItemCount(): Int = item.size
}