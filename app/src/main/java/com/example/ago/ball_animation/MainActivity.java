package com.example.ago.ball_animation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int xStart = 0;
        int yStart = 0;

        int frameHeight = 50;
        int frameWidth = 50;

        int iFramesY = 2;
        int iFramesX = 12;

        Bitmap spriteSheet = BitmapFactory.decodeResource(getResources(), R.drawable.ball_spritesheet);

        Sprite sprite = new Sprite(xStart,yStart,frameHeight,frameWidth,iFramesY,iFramesX, spriteSheet);

        Drawable[] drawables = sprite.separateSheetToDrawables(getResources());

        int x = drawables.length;


        ImageView iwBall = (ImageView) findViewById(R.id.viewBall);
        AnimationDrawable animation = new AnimationDrawable();
        //BitmapDrawable bmdAnimation = new BitmapDrawable(drawables);

        for(Drawable draw: drawables){
            animation.addFrame(draw, 100);
        }

        iwBall.setBackground(animation);
        animation.start();
    }


}
