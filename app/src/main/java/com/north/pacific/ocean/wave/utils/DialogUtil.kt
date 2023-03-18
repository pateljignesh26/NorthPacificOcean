package com.north.pacific.ocean.wave.utils


import android.app.AlertDialog
import android.content.Context
import com.north.pacific.ocean.wave.R


fun <T> Context.showAlertDialog(title: String, message: String, onClickYes: () -> T) {
    AlertDialog.Builder(this, R.style.dialog_theme)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("Yes") { _, _ ->
            onClickYes()
        }
        .setNegativeButton("Cancel", null)
        .show()
}
