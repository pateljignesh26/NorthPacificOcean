package com.north.pacific.ocean.wave.fg

import androidx.lifecycle.ViewModelProvider
import com.north.pacific.ocean.wave.ParentFrag
import com.north.pacific.ocean.wave.databinding.FgAlbumBinding
import com.north.pacific.ocean.wave.vm.AudioVm

class FgMsAlbum : ParentFrag<FgAlbumBinding>() {

    private lateinit var mAudioVM: AudioVm

    override fun setViewBinding() = FgAlbumBinding.inflate(layoutInflater)

    override fun bindObjects() {
        mAudioVM = ViewModelProvider(this)[AudioVm::class.java]
    }

    override fun bindListener() {

    }

    override fun bindMethod() {
        mAudioVM.mAllAlbums.observe(this) {
            println("music loader : All Albums ==> ${it.size} ::--> $it")
        }
    }
}