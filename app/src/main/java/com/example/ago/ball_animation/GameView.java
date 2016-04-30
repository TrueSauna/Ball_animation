package com.example.ago.ball_animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Ago on 28.4.2016.
 */

//NOT USED

public class GameView extends SurfaceView implements Runnable {

    Thread gameThread = null;
    SurfaceHolder ourHolder;
    volatile boolean playing;
    Canvas canvas;
    Paint paint;
    long fps;
    private long timeThisFrame;
    Bitmap bitmapBob;
    boolean isMoving = false;
    float walkSpeedPerSecond = 250;
    float bobXPosition = 10;

    private int frameWidth = 50;
    private int frameHeight = 50;
    private int frameCount = 12;
    private int currentFrame = 0;
    private long lastFrameChangeTime = 0;
    private int frameLengthInMilliseconds = 100;

    private Rect frameToDraw = new Rect(
            0,
            0,
            frameWidth,
            frameHeight);

    RectF whereToDraw = new RectF(
            bobXPosition,                0,
            bobXPosition + frameWidth,
            frameHeight);

    public GameView(Context context) {
        super(context);
    }

    @Override
    public void run() {

    }
}
