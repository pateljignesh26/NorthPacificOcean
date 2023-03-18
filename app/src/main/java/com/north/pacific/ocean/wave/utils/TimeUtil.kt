package  com.north.pacific.ocean.wave.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


fun Long.formatDate(): String {
    val time = Date(this)
    val format = SimpleDateFormat("dd MMMM yyyy")
    return format.format(time)
}

fun Long.formatDateDayOnly(): String {
    val time = Date(this)
    val format = SimpleDateFormat("dd")
    return format.format(time)
}

fun Long.formatDateMonthAndYear(): String {
    val time = Date(this)
    val format = SimpleDateFormat("MMM yy")
    return format.format(time)
}

fun Long.recordingPrefix(): String {
    val time = Date(this)
    val format = SimpleDateFormat("dd_MM_yyyy_HH_mm_ss")
    return format.format(time)
}

fun Long.formatDateDMYHMA(): String {
    val time = Date(this)
    val format = SimpleDateFormat("dd MMM yyyy HH:mm a")
    return format.format(time)
}

fun Long.formatTimeHMS(): String {
    val length = this
    val timeUnit = TimeUnit.MILLISECONDS
    val numHour = timeUnit.toHours(length)
    val numMinutes = timeUnit.toMinutes(length)
    val numSeconds = timeUnit.toSeconds(length)
    return if (numHour == 0L) {
        String.format(Locale.getDefault(), "%02d:%02d", numMinutes, numSeconds % 60)
    } else {
        String.format(
            Locale.getDefault(),
            "%02d:%02d:%02d",
            numHour,
            numMinutes % 60,
            numSeconds % 60
        )
    }
}
