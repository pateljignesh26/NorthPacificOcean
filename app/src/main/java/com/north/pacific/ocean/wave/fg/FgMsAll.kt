package com.north.pacific.ocean.wave.fg

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.north.pacific.ocean.wave.ParentFrag
import com.north.pacific.ocean.wave.ap.AdpAllMsc
import com.north.pacific.ocean.wave.databinding.FgAllBinding
import com.north.pacific.ocean.wave.vm.AudioVm

class FgMsAll : ParentFrag<FgAllBinding>() {
    private lateinit var mAudioVM: AudioVm
    private lateinit var mAdpAllMsc: AdpAllMsc

    override fun setViewBinding() = FgAllBinding.inflate(layoutInflater)

    override fun bindObjects() {
        mAudioVM = ViewModelProvider(mActivity)[AudioVm::class.java]
        mAdpAllMsc = AdpAllMsc(mActivity)
    }

    override fun bindListener() {

    }

    override fun bindMethod() {
        binding.rcvMusicAll.apply {
            layoutManager = GridLayoutManager(mActivity, 1)
            adapter = mAdpAllMsc
        }
        mAudioVM.mAllDataState.observe(this) {
            println("music loader : All Audio ==> ${it.size} ::--> $it")
            mAdpAllMsc.setData(it)
        }
    }
}