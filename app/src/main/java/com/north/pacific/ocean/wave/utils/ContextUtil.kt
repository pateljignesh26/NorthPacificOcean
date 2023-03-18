package  com.north.pacific.ocean.wave.utils

import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager


fun Context.pastFromClipboard(): String {
    val clipboard = (getSystemService(Context.CLIPBOARD_SERVICE)) as? ClipboardManager
    return (clipboard?.primaryClip?.getItemAt(0)?.text ?: "").toString()
}

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val activeNetworkInfo = connectivityManager?.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}


fun Activity.shareVideo(audioFile: String) {
    val intent3 = Intent(Intent.ACTION_SEND)
    intent3.putExtra(Intent.EXTRA_STREAM, Uri.parse(audioFile))
    intent3.type = "video/*"
    startActivity(Intent.createChooser(intent3, "Share Video"))
}

fun Activity.playVideo(audioFile: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(audioFile))
    intent.setDataAndType(Uri.parse(audioFile), "video/*")
    startActivity(intent)
}


fun Context.shareApp() {
    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND
    sendIntent.putExtra(
        Intent.EXTRA_TEXT,
        "https://play.google.com/store/apps/details?id=$packageName"
    )
    sendIntent.type = "text/plain"
    startActivity(sendIntent)
}


fun Activity.hideKeyboard() {
    val imm: InputMethodManager =
        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view: View? = currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}