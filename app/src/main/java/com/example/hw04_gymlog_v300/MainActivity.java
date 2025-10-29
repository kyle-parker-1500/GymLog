package com.example.hw04_gymlog_v300;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hw04_gymlog_v300.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private static final String tag = "PARK_GYMLOG";
    String mExercise = "";
    double mWeight = 0.0;
    int mReps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay();
            }
        });
    }

    private void updateDisplay() {

    }

    private void getInformationFromDisplay() {
        mExercise = binding.exerciseInputEditText.getText().toString();

        // parseDouble throws numberFormatException -> needs try catch
        try {
            mWeight = Double.parseDouble(binding.weightInputEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d(tag, "Error reading value from Weight Edit Text.");
        }

        // parseInt throws numberFormatException -> needs try catch
        try {
            mReps = Integer.parseInt(binding.repInputEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d(tag, "Error reading value from Reps Edit Text.");
        }
    }
}