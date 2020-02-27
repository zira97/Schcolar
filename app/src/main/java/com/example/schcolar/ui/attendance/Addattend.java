package com.example.schcolar.ui.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.DatePicker;


import com.example.schcolar.R;
import com.example.schcolar.model.User_Info;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Addattend extends AppCompatActivity implements View.OnClickListener {

    EditText date, time;
    private int mYear, mMonth, mDay, mHour, mMinute;
    Spinner venue, category;
    Button btnCon, btnCan;
    String mdate, mtime, mvenue, mcategory;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addattend);

// Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mDatabaseReference = database.getReference("Addattend");

        date = (EditText) findViewById(R.id.etChooseDate);
        time = (EditText) findViewById(R.id.etChooseTime);
        venue = (Spinner) findViewById(R.id.spinner1);
        category = (Spinner) findViewById(R.id.spinner2);
        btnCan = (Button) findViewById(R.id.btnCan);
        btnCon = (Button) findViewById(R.id.btnCon);


        date.setOnClickListener(this);
        time.setOnClickListener(this);
        btnCon.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        if (v == date) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == time) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            time.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v == venue) {
            String.valueOf(venue.getSelectedItemId());
            mvenue= (String) venue.getSelectedItem();
        }
        if (v == category) {
            String.valueOf(category.getSelectedItemId());
            mcategory=category.getTransitionName();
        }

        if (v == btnCon) {
            savedata(date.getText().toString(),time.getText().toString(),mvenue,mcategory);
            Intent intToHome = new Intent(Addattend.this, AttendanceFragment.class);
            startActivity(intToHome);

        }

    }

    private void savedata(String date,String time,String venue,String category){
        User_Info user_info=new User_Info(date,time,venue,category);
        mDatabaseReference.child("profile").setValue(user_info);

    }
}

