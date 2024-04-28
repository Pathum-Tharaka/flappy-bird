package com.example.myapplicationbird

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.content.res.Resources

class BitmapBank(private val res: Resources?) {
    var background: Bitmap
    var bird: Array<Bitmap?>

    init {
        background = BitmapFactory.decodeResource(res, R.drawable.img)
        background = scaleImage(background)
        bird = arrayOfNulls(4)
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.pngwing)
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.pngwing1)
        bird[2] = BitmapFactory.decodeResource(res, R.drawable.pngwing2)
        bird[3] = BitmapFactory.decodeResource(res, R.drawable.pngwing3)
    }

    fun getBird(frame: Int): Bitmap? {
        return bird[frame]
    }

    fun getBirdWidth(): Int {
        return bird[0]?.width ?: 0
    }

    fun getBirdHeight(): Int {
        return bird[0]?.height ?: 0
    }

    val backgroundWidth: Int
        get() = background.width

    val backgroundHeight: Int
        get() = background.height

    private fun scaleImage(bitmap: Bitmap): Bitmap {
        val widthHeightRatio = backgroundWidth.toFloat() / backgroundHeight.toFloat()
        val backgroundScaleWidth = (widthHeightRatio * AppConstants.SCREEN_HEIGHT).toInt()
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false)
    }
}