package  com.north.pacific.ocean.wave.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager


fun Activity.changeStatusBarColor(color: Int) {
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = color
    }
}

fun Activity.changeNavigationBarColor(color: Int) {
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.navigationBarColor = color
    }
}

fun Activity.setStatusBarUiTheme(isLight: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
       window?.decorView?.let {
            it.systemUiVisibility = if (isLight)
                it.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR // dark icons
            else
                it.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() // light icons
        }
    }
}
