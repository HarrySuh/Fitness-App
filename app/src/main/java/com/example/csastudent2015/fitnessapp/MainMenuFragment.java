package com.example.csastudent2015.fitnessapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by csastudent2015 on 1/26/16.
 */
public class MainMenuFragment extends Fragment{
    private Button summary;
    private Button bodyInfo;
    private Button exerciseButton; //exercise button
    private Button tools;
    private Switch notification;
    private Button about;
    private PendingIntent pendingIntent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);

        bodyInfo = (Button) rootView.findViewById(R.id.bodyInfo_button);
        exerciseButton = (Button) rootView.findViewById(R.id.dietInfo_button);
        tools = (Button) rootView.findViewById(R.id.tools_button);
        notification = (Switch) rootView.findViewById(R.id.notification_switch);


        exerciseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new ExerciseFragment(), "ExerciseFragment");
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        bodyInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new BodyInfoFragment(), "BodyInfoFragment");
                ft.addToBackStack(null);
                ft.commit();
            }
        });



        tools.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new Stopwatch(), "stopwatch");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        //Alarm Section
        notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Context context = getActivity().getApplicationContext();
                    CharSequence text = "Notification is turned on";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    Calendar calendar = new GregorianCalendar();
                    calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 2);
                    //calendar.set(Calendar.HOUR);
                    Intent myIntent = new Intent(getActivity(), MyReceiver.class);
                    pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, myIntent,0);

                    AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(getActivity().ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

                }
            }
        });

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.YEAR, 2013);
        calendar.set(Calendar.DAY_OF_MONTH, 13);

        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 48);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.AM_PM,Calendar.PM);


        return rootView;

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);



    }
}
