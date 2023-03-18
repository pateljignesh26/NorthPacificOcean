package com.north.pacific.ocean.wave.fg

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.north.pacific.ocean.wave.ParentFrag
import com.north.pacific.ocean.wave.ap.AdpAllArtist
import com.north.pacific.ocean.wave.databinding.FgMscArtistBinding
import com.north.pacific.ocean.wave.vm.AudioVm

class FgMsArtist : ParentFrag<FgMscArtistBinding>() {

    private lateinit var mAudioVM: AudioVm

    private lateinit var mAdpAllArtist: AdpAllArtist

    override fun setViewBinding() = FgMscArtistBinding.inflate(layoutInflater)

    override fun bindObjects() {
        mAudioVM = ViewModelProvider(mActivity)[AudioVm::class.java]
        mAdpAllArtist = AdpAllArtist(mActivity)
    }

    override fun bindListener() {

    }

    override fun bindMethod() {
        binding.rcvMusicArtist.apply {
            layoutManager = GridLayoutManager(mActivity, 2)
            adapter = mAdpAllArtist
        }
        mAudioVM.mAllArtis.observe(this) {
            println("music loader : All Artists ==> ${it.size} ::--> $it")
            mAdpAllArtist.setData(it)
        }
    }
}