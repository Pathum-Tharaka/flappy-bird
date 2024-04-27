package com.example.myapplicationbird

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context?) : SurfaceView(context), SurfaceHolder.Callback {
    private var gameThread: GameThread? = null

    init {
        initView()
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        if (!gameThread?.isRunning()!!) {
            gameThread = GameThread(holder)
            gameThread?.start()
        } else {
            gameThread?.start()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        if (gameThread?.isRunning() == true) {
            gameThread?.setIsRunning(false)
            var retry = true
            while (retry) {
                try {
                    gameThread?.join()
                    retry = false
                } catch (e: InterruptedException) {
                }
            }
        }
        initView()
    }

    private fun initView() {
        val holder = holder
        holder.addCallback(this)
        isFocusable = true
        gameThread = GameThread(holder)
    }
}