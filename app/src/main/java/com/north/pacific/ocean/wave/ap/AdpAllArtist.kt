package com.north.pacific.ocean.wave.ap

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.north.pacific.ocean.wave.databinding.ItemAllArtistBinding
import com.north.pacific.ocean.wave.dt.DtAudio

class AdpAllArtist(val mContext: Context) : RecyclerView.Adapter<AdpAllArtist.AllMscHolder>() {

    var all = mutableMapOf<String, ArrayList<DtAudio>>()
    val keys = arrayListOf<String>()

    fun setData(all: MutableMap<String, ArrayList<DtAudio>>) {
        this.all = all
        keys.clear()
        keys.addAll(all.keys)
        notifyDataSetChanged()
    }

    class AllMscHolder(val binding: ItemAllArtistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AllMscHolder(
        ItemAllArtistBinding.inflate(LayoutInflater.from(mContext))
    )

    override fun getItemCount() = all.size

    override fun onBindViewHolder(holder: AllMscHolder, position: Int) {
        holder.binding.tvName.text = keys[holder.adapterPosition]
        holder.binding.tvCount.text = all[keys[holder.adapterPosition]]?.size.toString()
    }
}