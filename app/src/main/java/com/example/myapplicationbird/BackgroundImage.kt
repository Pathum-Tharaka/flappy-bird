package com.example.myapplicationbird

class BackgroundImage {
    private var backgroundImageX: Int = 0
    private var backgroundImageY: Int = 0
    private val backgroundImageVelocity: Int = 3

    fun getX(): Int {
        return backgroundImageX
    }

    fun getY(): Int {
        return backgroundImageY
    }

    fun setX(backgroundImageX: Int) {
        this.backgroundImageX = backgroundImageX
    }

    fun setY(backgroundImageY: Int) {
        this.backgroundImageY = backgroundImageY
    }

    fun getVelocity(): Int {
        return backgroundImageVelocity
    }
}