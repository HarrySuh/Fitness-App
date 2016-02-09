package com.example.csastudent2015.fitnessapp;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


/**
 * Created by csastudent2015 on 2/3/16.
 */
public class Stopwatch extends Fragment implements View.OnClickListener {

    private Chronometer chronometer;
    private Button mStart;
    private Button mStop;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.stopwatch, container, false);
//
        //stopwatch
        chronometer = (android.widget.Chronometer) rootView.findViewById(R.id.chronometer);
        mStart = (Button) rootView.findViewById(R.id.start_button);
        mStart.setOnClickListener(this);
        mStop = (Button) rootView.findViewById(R.id.stop_button);
        mStop.setOnClickListener(this);

    return rootView;

}

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.start_button:
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                break;
            case R.id.stop_button:
                chronometer.stop();
                break;
        }
    }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
}
