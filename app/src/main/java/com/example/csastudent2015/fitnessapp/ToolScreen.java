package com.example.csastudent2015.fitnessapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.support.v4.app.Fragment;

/**
 * Created by csastudent2015 on 1/26/16.
 */
public class ToolScreen extends Fragment implements AdapterView.OnItemSelectedListener{
    private Button mTools;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tools, container, false);

        mTools = (Button) rootView.findViewById(R.id.tools_button);
        mTools.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final FragmentTransaction ft = getFragmentManager().beginTransaction();

            }
        });

        return rootView;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        //Exercise.burn(parent.getItemAtPosition(pos).toString());
        //
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
