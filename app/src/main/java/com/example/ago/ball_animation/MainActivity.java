package com.example.ago.ball_animation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
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

        ImageView iwBall = (ImageView) findViewById(R.id.viewBall);

        //fetch the spritesheet and make an instance of it
        Bitmap spriteSheet = BitmapFactory.decodeResource(getResources(), R.drawable.ball_spritesheet3);
        Sprite sprite = new Sprite(xStart,yStart,frameHeight,frameWidth,iFramesY,iFramesX, spriteSheet);

        //cut the spritesheet into separate images and layer the correct parts together to form one frame of the animation
        //this method takes imageview just for testing purposes inside the method
        Drawable[] drawables = sprite.separateSheetToDrawables(getResources(), iwBall);

        //animate the processed array of drawables:
        AnimationDrawable animation = new AnimationDrawable();

        //foreach:
        for(Drawable layeredImage: drawables){
            animation.addFrame(layeredImage, 50);
        }

        //start animation:
        if (iwBall != null) {
            iwBall.setBackground(animation);
            animation.start();
        }




    }


}
