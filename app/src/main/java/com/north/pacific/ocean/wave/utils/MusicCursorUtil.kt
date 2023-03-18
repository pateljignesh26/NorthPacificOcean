package com.north.pacific.ocean.wave.utils

import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Build
import android.provider.MediaStore


@SuppressLint("Range")
fun Cursor.getArtist(): String =
    this.getString(this.getColumnIndex(MediaStore.Audio.Media.ARTIST))

@SuppressLint("Range")
fun Cursor.getAlbum(): String =
    this.getString(this.getColumnIndex(MediaStore.Audio.Media.ALBUM))


@SuppressLint("Range")
fun Cursor.getId(): String =
    this.getString(this.getColumnIndex(MediaStore.Audio.Media._ID))


@SuppressLint("Range")
fun Cursor.getAudioName(): String =
    this.getString(this.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME))


@SuppressLint("Range")
fun Cursor.getAudioPath(): String =
    this.getString(this.getColumnIndex(MediaStore.Audio.AudioColumns.DATA))


@SuppressLint("Range")
fun Cursor.getModifiedDate(): Long =
    this.getLong(this.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED)) * 1000


@SuppressLint("Range")
fun Cursor.getAudioSize(): String =
    this.getString(this.getColumnIndex(MediaStore.Audio.Media.SIZE))
