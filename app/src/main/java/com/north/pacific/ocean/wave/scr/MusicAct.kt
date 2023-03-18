package com.north.pacific.ocean.wave.scr

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.loader.app.LoaderManager
import androidx.viewpager.widget.ViewPager
import com.north.pacific.ocean.wave.R
import com.north.pacific.ocean.wave.ap.AdpPager
import com.north.pacific.ocean.wave.dt.DtAudio
import com.north.pacific.ocean.wave.dt.call.OnMsLoadListener
import com.north.pacific.ocean.wave.fg.FgMsAlbum
import com.north.pacific.ocean.wave.fg.FgMsAll
import com.north.pacific.ocean.wave.fg.FgMsArtist
import com.north.pacific.ocean.wave.ucs.LoadAllAudioUcs
import com.north.pacific.ocean.wave.vm.AudioVm

class MusicAct : AppCompatActivity() {


    private lateinit var mAudioVM: AudioVm
    private var fgList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

         mAudioVM = ViewModelProvider(this)[AudioVm::class.java]

        fgList.apply {
            add(FgMsAll())
            add(FgMsArtist())
            add(FgMsAlbum())
        }

        val adp = AdpPager(supportFragmentManager)
        adp.setPages(fgList)
        findViewById<ViewPager>(R.id.pagerMusic).apply {
            adapter = adp
        }

        findViewById<ViewPager>(R.id.pagerMusic).post {
            LoadAllAudioUcs(this@MusicAct, object : OnMsLoadListener {
                override fun onLoaderReady(callBack: LoaderManager.LoaderCallbacks<Cursor>) {
                    LoaderManager.getInstance(this@MusicAct).initLoader(0, null, callBack)
                    println("music loader : Start ==> Start loading data")
                }

                override fun onNoDataFound(message: String) {
                    println("music loader : Empty ==> $message")
                }

                override fun onLoadingError(errorMessage: String) {
                    println("music loader : Error ==> $errorMessage")
                }

                override fun onLoadingComplete(dataList: ArrayList<DtAudio>) {
                    mAudioVM.loadData(dataList)
                }

            }).invoke()

        }

    }
}