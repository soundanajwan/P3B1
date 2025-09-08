package com.example.listof

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listof.databinding.ItemDisasterBinding
// tambahkan onclick
typealias OnClickDisaster = (Disaster) -> Unit
        // buat agar menerima data list disaster
        class DisasterAdapter(private val listDisaster: List<Disaster>, private val onClickDisaster: OnClickDisaster) : RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {
        inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
        RecyclerView.ViewHolder(binding.root) {
    // crate func to handle how to bind data
    fun bind(data: Disaster)
    {
        with(binding)
        {
            txtDisasterName.setText(data.name)
            txtDisasterType.setText(data.type)
            txtDisasterLocation.setText(data.location)
            itemView.setOnClickListener {
            onClickDisaster(data)
        }
        }
    }
}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
    // bikin binding dari context parent
    val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    // return
    return ItemDisasterViewHolder(binding)
}

        override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
    holder.bind(listDisaster[position])
}

        override fun getItemCount(): Int  = listDisaster.size


}