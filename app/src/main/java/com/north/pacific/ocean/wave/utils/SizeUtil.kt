package  com.north.pacific.ocean.wave.utils

import java.text.DecimalFormat

fun Long.humanReadableSize(): String {
    val size = this
    val df = DecimalFormat("0.00")
    val sizeKb = 1024.0f
    val sizeMb = sizeKb * sizeKb
    val sizeGb = sizeMb * sizeKb
    val sizeTerra = sizeGb * sizeKb
    if (size < sizeMb) return df.format(size / sizeKb) + " Kb" else if (size < sizeGb) return df.format(
        size / sizeMb
    ) + " Mb" else if (size < sizeTerra) return df.format(size / sizeGb) + " Gb"
    return ""
}