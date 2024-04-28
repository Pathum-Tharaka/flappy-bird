package com.example.myapplicationbird

import android.graphics.Canvas

class GameEngine {
    private val backgroundImage = BackgroundImage()

    fun updateAndDrawBackgroundImage(canvas: Canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity())
        if (backgroundImage.getX() < -AppConstants.getBitmapBank().backgroundWidth) {
            backgroundImage.setX(0)
        }
        canvas.drawBitmap(
            AppConstants.getBitmapBank().background,
            backgroundImage.getX().toFloat(),
            backgroundImage.getY().toFloat(),
            null
            if (backgroundImage.getX()<-(AppConstants.getBitmapBank().getBackgroundWidth()-AppConstants.SCREEN_WIDTH)) {

                canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), left:backgroundImage.getX() +
                        AppConstants.getBitmapBank().getBackgroundWidth(),backgroundImage.getY(),paint:null);
            }

        )
    }
}