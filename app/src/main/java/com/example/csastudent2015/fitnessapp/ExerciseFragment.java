package com.example.csastudent2015.fitnessapp;


import android.app.Activity;
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

/**
 * Created by csastudent2015 on 1/14/16.
 */
public class ExerciseFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    private Spinner exerciseSpinner;
    private Button enter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise, container, false);
        exerciseSpinner = (Spinner) rootView.findViewById(R.id.exercise_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.exercise_array, android.R.layout.simple_spinner_dropdown_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        exerciseSpinner.setAdapter(adapter);
        exerciseSpinner.setOnItemSelectedListener(this);

        enter = (Button) rootView.findViewById(R.id.enter_button);
        enter.setOnClickListener(new View.OnClickListener() {
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
            Exercise.burn(parent.getItemAtPosition(pos).toString());
            //
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }

}