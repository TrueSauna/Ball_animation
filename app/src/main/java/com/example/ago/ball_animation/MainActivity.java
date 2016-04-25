package com.example.ago.ball_animation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = (ImageView)findViewById(R.id.viewBall);


        AnimationDrawable aDBall = (AnimationDrawable)findViewById(R.id.viewBall).getBackground();
        //shit

        //aDBall.setDither(false);

        //useless atm:
        for(int i = 0 ; i < aDBall.getNumberOfFrames() ; i++){
            //Drawable dFrame = aDBall.getFrame(i);
            //dFrame.setFilterBitmap(false);
            //dFrame.setDither(false);

            //Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), dFrame.);
        }



        ((AnimationDrawable)findViewById(R.id.viewBall).getBackground()).start();

    }


}
