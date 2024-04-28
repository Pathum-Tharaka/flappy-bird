package com.example.myapplicationbird

import android.graphics.Canvas

class GameEngine {
    private val backgroundImage = BackgroundImage()
    private val bird = Bird()
    companion object {
        var gameState: Int = 0
    }

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
        )
        if (backgroundImage.getX() < -(AppConstants.getBitmapBank().backgroundWidth - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(
                AppConstants.getBitmapBank().background,
                backgroundImage.getX() + AppConstants.getBitmapBank().backgroundWidth.toFloat(),
                backgroundImage.getY().toFloat(),
                null
            )
        }
    }

    fun updateAndDrawBird(canvas: Canvas) {
        if (gameState == 1) {
            // No implementation provided
        }
        if (bird.getY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBirdHeight()) || bird.getVelocity() < 0) {
            bird.setVelocity(bird.getVelocity() + AppConstants.gravity)
            bird.setY(bird.getY() + bird.getVelocity())
        }
        val currentFrame = bird.currentFrame
        canvas.drawBitmap(
            AppConstants.getBitmapBank().getBird(currentFrame),
            bird.getX().toFloat(),
            bird.getY().toFloat(),
            null
        )
        bird.currentFrame = (currentFrame + 1) % bird.maxFrame
    }
}