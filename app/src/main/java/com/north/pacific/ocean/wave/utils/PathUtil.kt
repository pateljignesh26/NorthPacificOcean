package  com.north.pacific.ocean.wave.utils

import android.os.Environment
import java.io.File


val instaSaverFolder = Environment
    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path
    .plus(File.separator)
    .plus("Insta Saver 2023")
    .plus(File.separator)