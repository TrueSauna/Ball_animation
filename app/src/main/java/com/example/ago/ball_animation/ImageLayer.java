package com.example.ago.ball_animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/**
 * Created by Ago on 28.4.2016.
 */

//NOT USED

public class ImageLayer {

   public ImageLayer(Drawable[] d) {
      this.d = d;
   }

   public Drawable[] getD() {
      return d;
   }

   public void setD(Drawable[] d) {
      this.d = d;
   }

   private Drawable[] d;

}
