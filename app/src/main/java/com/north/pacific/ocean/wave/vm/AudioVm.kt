package com.north.pacific.ocean.wave.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.north.pacific.ocean.wave.dt.DtAudio
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AudioVm @Inject constructor() : ViewModel(

) {

    val mAllDataState = MutableLiveData<List<DtAudio>>()
    val mAllArtis = MutableLiveData<MutableMap<String, ArrayList<DtAudio>>>()
    val mAllAlbums = MutableLiveData<ArrayList<String>>()

    fun loadData(rawData: ArrayList<DtAudio>) {
        val data = rawData.sortedByDescending {
            it.dateModified
        }
        mAllDataState.value = data


        val artis = mutableMapOf<String, ArrayList<DtAudio>>()
        data.forEach { song ->
            if (artis.containsKey(song.artist)) {
                if (!artis[song.artist]!!.contains(song))
                    artis[song.artist]!!.add(song)
            } else {
                artis[song.artist] = arrayListOf(song)
            }

        }
        mAllArtis.value = artis


        val albums = arrayListOf<String>()
        data.forEach {
            val parent = File(it.path).parentFile?.name
            if (!albums.contains(parent))
                albums.add(parent ?: "unknown")
        }
        mAllAlbums.value = albums
    }
}