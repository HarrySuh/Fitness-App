package com.example.csastudent2015.fitnessapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by csastudent2015 on 2/3/16.
 */
public class PictureUtils {
    public static Bitmap getScaledBitmap(String path,
                                         int destWidth, int destHeight) {
        //Read the dimensions of the image from the disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int inSampleSize = 1;
        //if either source dimensions is bigger than the
        //corresponding target dimension....
        if(srcHeight > destHeight || srcWidth > destWidth) {
            //find the larger dimension and use that to
            //get the new inSampleSize
            if(srcWidth > srcHeight) {
                inSampleSize = Math.round(srcWidth/destWidth);
            }
            else {
                inSampleSize = Math.round(srcHeight/destHeight);
            }
        }
        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        //read and create the actual bitmap file
        return BitmapFactory.decodeFile(path, options);
    }

    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }
}
