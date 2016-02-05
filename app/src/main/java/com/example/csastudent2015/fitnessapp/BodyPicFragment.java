package com.example.csastudent2015.fitnessapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_PHOTO){
            updatePhotoView();
        }
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bodypic, container, false);

    mBodyPic = (ImageView) rootView.findViewById(R.id.BodyPic);
        mBodyCamera = (ImageButton) rootView.findViewById(R.id.BodyCamera);
        mBackToMenu = (Button) rootView.findViewById(R.id.BackToMenu);

        final Intent captureSelfie = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        boolean canTakeSelfie = mBodyFile != null && captureSelfie.resolveActivity(getActivity().getPackageManager()) != null;
        mBodyCamera.setEnabled(canTakeSelfie);
        if(canTakeSelfie) {

            Uri uri = Uri.fromFile(mBodyFile);
            captureSelfie.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }
        mBodyCamera.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 startActivityForResult(captureSelfie, REQUEST_PHOTO);
                                             }
                                         }
        );
        updatePhotoView();

        mBackToMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new MainMenuFragment(), "MainMenuFragment");
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        return rootView;

    }


    private void updatePhotoView() {
        if (mBodyFile == null || !mBodyFile.exists()) {
            mBodyPic.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mBodyFile.getPath(), getActivity());
            mBodyPic.setImageBitmap(bitmap);
        }
    }
}
