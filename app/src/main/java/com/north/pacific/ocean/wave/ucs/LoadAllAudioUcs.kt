package com.north.pacific.ocean.wave.ucs

import android.content.Context
import com.north.pacific.ocean.wave.dt.call.OnMsLoadListener
import com.north.pacific.ocean.wave.repo.MusicRepo

class LoadAllAudioUcs(
    private val mContext: Context,
    private val call: OnMsLoadListener
) {

    operator fun invoke() {
        MusicRepo(mContext = mContext, call = call).invoke()
    }
}