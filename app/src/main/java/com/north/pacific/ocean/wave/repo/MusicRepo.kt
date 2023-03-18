package com.north.pacific.ocean.wave.repo

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import com.north.pacific.ocean.wave.dt.DtAudio
import com.north.pacific.ocean.wave.dt.call.OnMsLoadListener
import com.north.pacific.ocean.wave.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MusicRepo(
    private val mContext: Context,
    private val call: OnMsLoadListener
) {

    operator fun invoke() {
        val mlList = arrayListOf<DtAudio>()
        val loader = object : LoaderManager.LoaderCallbacks<Cursor> {
            override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
                val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"
                return CursorLoader(
                    mContext,
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    null,
                    selection,
                    null,
                    null
                )
            }

            override fun onLoaderReset(loader: Loader<Cursor>) {

            }

            @SuppressLint("Range")
            override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        if (data != null) {
                            if (data.moveToFirst()) {
                                do {
                                    mlList.add(
                                        DtAudio(
                                            id = data.getId(),
                                            name = data.getAudioName(),
                                            path = data.getAudioPath(),
                                            dateModified = data.getModifiedDate(),
                                            album = data.getAlbum(),
                                            artist = data.getArtist()
                                        )
                                    )
                                } while (data.moveToNext())
                            } else {
                                withContext(Dispatchers.Main) {
                                    call.onNoDataFound("empty cursor")
                                }

                            }
                            if (mlList.isNotEmpty())
                                withContext(Dispatchers.Main) {
                                    call.onLoadingComplete(mlList)
                                }
                        } else {
                            withContext(Dispatchers.Main) {
                                call.onNoDataFound("empty cursor")
                            }
                        }
                    } catch (error: Exception) {
                        withContext(Dispatchers.Main) {
                            call.onLoadingError(error.message.toString())
                        }
                    }
                }

            }
        }
        call.onLoaderReady(loader)
    }
}