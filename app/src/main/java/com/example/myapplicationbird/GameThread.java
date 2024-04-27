package com.example.myapplicationbird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

import androidx.core.content.UnusedAppRestrictionsConstants;

public class GameThread extends Thread{

    SurfaceHolder surfaceHolder; //Surfaceholder object reference
    boolean isRunning;
    long startTime,loopTime;
    long DELAY = 33;
    public GameThread(SurfaceHolder){
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }
    @Override
    public void run(){
        //looping until the boolean is false
        while(isRunning){
            startTime = SystemClock.uptimeMillis();
            Canvas canvas = surfaceHolder.lockCanvas(dirty:null);
            if(canvas!=null){
                synchronized (surfaceHolder){
                    AppConstants.getGameEndine().updateAndDrawBackgroundImage(canvas);
                    //unlocking the canvas
                    surfaceHolder.unlockCanvasAndPost(canvas);

                }
            }
            //loop time
            loopTime = SystemClock.uptimeMillis() - startTime;
            //pausing
            if(loopTime<DELAY){
                try{
                    Thread.sleep(millis:DELAY-loopTime);
                }
                catch(InterruptedException e){
                    Log.e(tag:"Interrupted",msg:"Interrupted while sleeping");
                }
            }
        }
    }
}
