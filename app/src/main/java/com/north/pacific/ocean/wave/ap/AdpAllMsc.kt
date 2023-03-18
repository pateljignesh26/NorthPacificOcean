package com.north.pacific.ocean.wave.ap

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.north.pacific.ocean.wave.databinding.ItemAllMscBinding
import com.north.pacific.ocean.wave.dt.DtAudio

class AdpAllMsc(val mContext: Context) : RecyclerView.Adapter<AdpAllMsc.AllMscHolder>() {

    var all = mutableListOf<DtAudio>()

    fun setData(all : List<DtAudio>){
        this.all.clear()
        this.all.addAll(all)
        notifyDataSetChanged()
    }

    class AllMscHolder(val binding: ItemAllMscBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AllMscHolder(
        ItemAllMscBinding.inflate(LayoutInflater.from(mContext))
    )

    override fun getItemCount() = all.size

    override fun onBindViewHolder(holder: AllMscHolder, position: Int) {
        holder.binding.tvName.text = all[holder.adapterPosition].name
    }
}