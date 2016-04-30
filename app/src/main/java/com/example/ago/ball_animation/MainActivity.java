package com.example.ago.ball_animation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

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


        ArrayList aListImagesToBeAnimated = new ArrayList();

        Bitmap spriteSheet = BitmapFactory.decodeResource(getResources(), R.drawable.ball_spritesheet);

        SpriteToArrayList sToA = new SpriteToArrayList(xStart,yStart,frameHeight,frameWidth,iFramesY,iFramesX, spriteSheet);
        aListImagesToBeAnimated = sToA.separateImagesFromSheet();

    }


}
