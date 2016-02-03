package com.example.csastudent2015.fitnessapp;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by csastudent2015 on 1/20/16.
 */
public class BodyPicFragment extends Fragment {

    private static final String FILENAME = "profile.json";
    private static final int REQUEST_PHOTO = 1;
    private ImageView mBodyPic;
    private ImageButton mBodyCamera;
    private Button mBackToMenu;
    private File mBodyFile;

    private void updatePhotoView() {
        if (mBodyFile == null || !mBodyFile.exists()) {
            mBodyPic.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mBodyFile.getPath(), getActivity());
            mBodyPic.setImageBitmap(bitmap);
        }
    }
}
