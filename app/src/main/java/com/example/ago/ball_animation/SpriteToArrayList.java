package com.example.ago.ball_animation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Ago on 30.4.2016.
 */
public class SpriteToArrayList extends AppCompatActivity {

    private int xStart = 0;
    private int yStart = 0;

    private int frameHeight = 0;
    private int frameWidth = 0;

    private int iFramesY = 0;
    private int iFramesX = 0;

    Bitmap spriteSheet = null;

    public int getxStart() {
        return xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getiFramesY() {
        return iFramesY;
    }

    public int getiFramesX() {
        return iFramesX;
    }

    public Bitmap getSpriteSheet() {
        return spriteSheet;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setiFramesY(int iFramesY) {
        this.iFramesY = iFramesY;
    }

    public void setiFramesX(int iFramesX) {
        this.iFramesX = iFramesX;
    }

    public void setSpriteSheet(Bitmap spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public SpriteToArrayList(int xStart, int yStart, int frameHeight, int frameWidth, int iFramesY, int iFramesX, Bitmap spriteSheet) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
        this.iFramesY = iFramesY;
        this.iFramesX = iFramesX;
        this.spriteSheet = spriteSheet;
    }


    public ArrayList separateImagesFromSheet(){

        ArrayList aListImagesToBeAnimated = new ArrayList();

        for(int i = 0 ; i < iFramesX ; i++){

            for(int j = 0; j < iFramesY ; i++){
                xStart = i * frameWidth;
                yStart = j * frameHeight;
                //xStart = (i % iFramesInRows) * frameWidth;
                //yStart = (i / iFramesInRows) * frameHeight;
                Bitmap bmFrame = Bitmap.createBitmap(frameWidth, frameHeight, Bitmap.Config.ARGB_8888);

                Canvas c = new Canvas(bmFrame);

                Rect src = new Rect(xStart, yStart, xStart + frameWidth, yStart + frameHeight);
                Rect dst = new Rect(0,0, frameWidth, frameHeight);

                c.drawBitmap(spriteSheet, src, dst, null);

                aListImagesToBeAnimated.add(bmFrame);
            }
        }

        return aListImagesToBeAnimated;
    }

    public void combineLayers(ArrayList al){

        Drawable[] layers = new Drawable[iFramesX];
        /*
        Drawable[] layers = new Drawable[2];
        layers[0] = getDrawable(R.drawable.ball1);
        layers[1] = getDrawable(R.drawable.hands1);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        */

        //ImageView iwBall = (ImageView) findViewById(R.id.viewBall);

        //iwBall.setImageDrawable(layerDrawable);

    }


}
