package com.example.schcolar.ui.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.schcolar.R;

public class AttendanceFragment extends Fragment {

    private View GalleryViewModel;
    private Button btn;

    public AttendanceFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_attendance, container, false);
        final Button btn = root.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getContext(),   Addattend.class);
                startActivity(myIntent);
            }
        });
        return root;
    }
    }
//https://docs.google.com/uc?export=download&id=13tC4nem2P9rQb3Gk0wcwsoAgLTGzybSQ