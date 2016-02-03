package com.example.csastudent2015.fitnessapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by csastudent2015 on 1/26/16.
 */
public class MainMenuFragment extends Fragment{
    private Button summary;
    private Button bodyInfo;
    private Button dietInfo; //exercise button
    private Button tools;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);

        summary = (Button) rootView.findViewById(R.id.summary_button);
        bodyInfo = (Button) rootView.findViewById(R.id.bodyInfo_button);
        dietInfo = (Button) rootView.findViewById(R.id.dietInfo_button);
        tools = (Button) rootView.findViewById(R.id.tools_button);

        return rootView;

    }
}
