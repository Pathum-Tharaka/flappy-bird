package com.example.myapplicationbird

import android.app.Activity
import android.os.Bundle

class GameActivity : Activity() {
    GameView gameView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameView = new GameView(context:this);
        setContentView(gameView);
    }
}
