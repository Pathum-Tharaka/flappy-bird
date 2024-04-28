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

    public Bitmap scaleImage(Bitmap bitmap){
        floatArrayOf() widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();

    int backgrounScaleWidth = (int) widthHeightRatio * AppConstants.SCREEN_HIEGHT;
        return Bitmap.createScaledBitmap(bitmap,backgroundScaleWidth,AppConstants.SCREEN_HEIGHT false
        )

    }
}
