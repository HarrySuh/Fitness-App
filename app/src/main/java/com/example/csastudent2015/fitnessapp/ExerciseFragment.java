package com.example.csastudent2015.fitnessapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by csastudent2015 on 1/14/16.
 */
public class ExerciseFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    private Spinner exerciseSpinner;
    private TextView exerciseText;
    private EditText minutesText;
    private Button enter;
    private String exercise;
    private double minutes;
    private String text;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putCharSequence(text, exerciseText.getText().toString());
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

        minutesText = (EditText)rootView.findViewById(R.id.minutes);
        minutesText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                if(s.toString().length() > 0)
                {
                    minutes = Double.parseDouble(s.toString());
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        exerciseText = (TextView)rootView.findViewById(R.id.exerciseText);

        enter = (Button) rootView.findViewById(R.id.enter_button);
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Exercise exercise1 = new Exercise(minutes);
                exercise1.burn(exercise);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                String old=exerciseText.getText().toString();
                String add = exercise + "\n" + "Minutes: " + minutes + "\n" + "Calories: " + exercise1.getCalories(); // can manipulate using substring also
                exerciseText.setText(old + "\n" + "\n" + add);
           }
        });

        if(savedInstanceState != null) {
            exerciseText.setText(savedInstanceState.getCharSequence(text));
        }
        return rootView;
    }

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            exercise = (parent.getItemAtPosition(pos).toString());
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }

}