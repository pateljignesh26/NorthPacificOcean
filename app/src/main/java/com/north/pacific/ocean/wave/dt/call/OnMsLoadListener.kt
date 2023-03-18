package com.north.pacific.ocean.wave.dt.call

import android.database.Cursor
import androidx.loader.app.LoaderManager
import com.north.pacific.ocean.wave.dt.DtAudio

interface OnMsLoadListener {
    fun onLoaderReady(callBack: LoaderManager.LoaderCallbacks<Cursor>)
    fun onNoDataFound(message: String)
    fun onLoadingError(errorMessage: String)
    fun onLoadingComplete(dataList: ArrayList<DtAudio>)
}