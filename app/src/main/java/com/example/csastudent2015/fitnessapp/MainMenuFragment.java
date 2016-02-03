package com.example.csastudent2015.fitnessapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
    private Button exerciseButton; //exercise button
    private Button tools;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);

        summary = (Button) rootView.findViewById(R.id.summary_button);
        bodyInfo = (Button) rootView.findViewById(R.id.bodyInfo_button);
        exerciseButton = (Button) rootView.findViewById(R.id.dietInfo_button);
        tools = (Button) rootView.findViewById(R.id.tools_button);


        exerciseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new ExerciseFragment(), "ExerciseFragment");
                ft.addToBackStack(null);

                ft.commit();

            }
        });

        return rootView;



    }


}
