package com.example.csastudent2015.fitnessapp;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by csastudent2015 on 1/20/16.
 */
public class BodyPic {
    public static final String PHOTO_FILENAME = "IMG_PROFILE.jpg";
    public String getPhotoFilename() { return PHOTO_FILENAME; }
    public File getPhotoFile(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        //if externalFilesDir is null, return null
        if(externalFilesDir == null)
            return null;
        //send back a new File with arguments
        //externalFilesDir and the photoFilename
        return new File(externalFilesDir, getPhotoFilename());
    }
}
