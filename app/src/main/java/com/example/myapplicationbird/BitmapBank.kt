package com.example.myapplicationbird

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.content.res.Resources

class BitmapBank(private val res: Resources?) {
    var background: Bitmap

    init {
        background = BitmapFactory.decodeResource(res, R.drawable.img)
    }

    val backgroundWidth: Int
        get() = background.getWidth()
    val backgroundHeight: Int
        get() = background.getHeight()
}
