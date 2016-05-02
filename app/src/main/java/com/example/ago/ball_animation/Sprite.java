package com.example.ago.ball_animation;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Ago on 30.4.2016.
 */
public class Sprite extends Activity {

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

    public Sprite(int xStart, int yStart, int frameHeight, int frameWidth, int iFramesY, int iFramesX, Bitmap spriteSheet) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
        this.iFramesY = iFramesY;
        this.iFramesX = iFramesX;
        this.spriteSheet = spriteSheet;
    }


    public Drawable[] separateSheetToDrawables(Resources res, ImageView iwBall){

        /*
        REMOVE

        did this for testing one image

        LayerDrawable[] layerDrawablesToBeAnimated = new LayerDrawable[iFramesX];
        boolean firstTime = true;

        Bitmap bmFrame = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmFrame);

        Rect src = new Rect(0, 0, 300, 300);
        Rect dst = new Rect(0,0, 300, 300);

        c.drawBitmap(spriteSheet, src, dst, null);

        Drawable d =  new BitmapDrawable(res, bmFrame);

        iwBall.setBackground(d);

        return d;
        */

        //TODO WTF IS THIS:
        frameHeight = frameHeight;
        frameWidth = frameWidth;

        //array of images that each will be combined from several layers
        LayerDrawable[] layerDrawablesToBeAnimated = new LayerDrawable[iFramesX];

        //this loop is done as many times as there are frames in WHOLE animations
        for(int i = 0 ; i < iFramesX ; i++){

            //ONE frame (image) that will contain several layers that are stacked in order
            Drawable[] imageLayers = new Drawable[iFramesY];

            //empty frame for the image to be copied from spritesheet
            Bitmap bmFrame = Bitmap.createBitmap(frameWidth, frameHeight, Bitmap.Config.ARGB_8888);

            //this loop is done as many times as there are layers in each frame of the animation
            for(int j = 0; j < iFramesY ; j++){
                xStart = i * frameWidth;
                yStart = j * frameHeight;

                //copying image from spritesheet from spesific spot to a spesific spot:
                Canvas canvas = new Canvas(bmFrame);
                Rect source = new Rect(xStart, yStart, xStart + frameWidth, yStart + frameHeight);
                Rect destination = new Rect(0,0, frameWidth, frameHeight);
                canvas.drawBitmap(spriteSheet, source, destination, null);

                //adding copied image (layer) to an array to eventually form ONE frame
                imageLayers[j] =  new BitmapDrawable(res, bmFrame);
            }

            //adding ONE combined image to an array to form an animation sequence
            LayerDrawable layerDrawable = new LayerDrawable(imageLayers);
            layerDrawablesToBeAnimated[i] = layerDrawable;
        }


        return layerDrawablesToBeAnimated;

    }

    //REMOVE OR NOT
    public Drawable combineOneLayer(){

        Drawable[] layers = new Drawable[2];

        int fHeight = 150;
        int fWidth = 150;

        return layers[1];

    }

    //REMOVE OR NOT
    public void combineLayers(Bitmap[] bmLayers){
        /*

        for(int i = 0 ; i < iFramesY ; i++) {


            for (int j = 0; j < iFramesY; j++) {

                Drawable[] layers = new Drawable[iFramesY];

                layers[i] = new BitmapDrawable(getResources(), bmLayers[i]);

                //REMOVE?
                //layers[0] = getDrawable(R.drawable.ball1);
                //layers[1] = getDrawable(R.drawable.hands1);


                //ImageView iwBall = (ImageView) findViewById(R.id.viewBall);

                //iwBall.setImageDrawable(layerDrawable);
            }

        }
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        */

    }


}
