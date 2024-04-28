package com.example.myapplicationbird

import android.graphics.Canvas
import android.os.SystemClock
import android.view.SurfaceHolder
import android.util.Log

class GameThread(private val surfaceHolder: SurfaceHolder) : Thread() {
    private var isRunning: Boolean = true
    private var startTime: Long = 0
    private var loopTime: Long = 0
    private val DELAY: Long = 33

    override fun run() {
        // Looping until the boolean is false
        while (isRunning) {
            startTime = SystemClock.uptimeMillis()
            val canvas = surfaceHolder.lockCanvas(null)
            if (canvas != null) {
                synchronized(surfaceHolder) {
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas)
                    AppConstants.getGameEngine().updateAndDrawBird(canvas)
                    // Unlocking the canvas
                    surfaceHolder.unlockCanvasAndPost(canvas)
                }
            }
            // Loop time
            loopTime = SystemClock.uptimeMillis() - startTime
            // Pausing
            if (loopTime < DELAY) {
                try {
                    Thread.sleep(DELAY - loopTime)
                } catch (e: InterruptedException) {
                    Log.e("Interrupted", "Interrupted while sleeping")
                }
            }
        }
    }

    fun isRunning(): Boolean {
        return isRunning
    }

    fun setIsRunning(state: Boolean) {
        isRunning = state
    }
}