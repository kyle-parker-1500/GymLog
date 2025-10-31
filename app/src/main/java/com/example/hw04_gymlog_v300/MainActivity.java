package com.example.hw04_gymlog_v300;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw04_gymlog_v300.database.GymLogRepository;
import com.example.hw04_gymlog_v300.database.entities.GymLog;
import com.example.hw04_gymlog_v300.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * May create error because of package path name!
     * Acting as a key, value is userId
     */
    private static final String MAIN_ACTIVITY_USER_ID = "com.example.hw04_gymlog_v300.MAIN_ACTIVITY_USER_ID";
    private ActivityMainBinding binding;
    private GymLogRepository repository;

    public static final String TAG = "PARK_GYMLOG";
    String mExercise = "";
    double mWeight = 0.0;
    int mReps = 0;

    // TODO: Add login information
    int loggedInUserId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // login page content -> displays login page
        loginUser();
        if (loggedInUserId == -1) {
            Intent intent = LoginActivity.loginIntentFactory(getApplicationContext());
            startActivity(intent);
        }

        // instance of application
        // gives us access to db
        repository = GymLogRepository.getRepository(getApplication());

        // enabling scroll in our displayed exercise info
        binding.logDisplayTextView.setMovementMethod(new ScrollingMovementMethod());

        // updating display before click (visible before action)
        updateDisplay();
        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                insertGymLogRecord();
                updateDisplay();
            }
        });

        // testing updateDisplay() -> should delete if finding issues
        binding.exerciseInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDisplay();
            }
        });
    }

    private void loginUser() {
        // TODO: Create login method
        // if there's no intent it'll kick us into the sign in page
        loggedInUserId = getIntent().getIntExtra(MAIN_ACTIVITY_USER_ID, -1);
    }

    // package private
    static Intent mainActivityIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MAIN_ACTIVITY_USER_ID, userId);
        return intent;
    }

    private void insertGymLogRecord() {
        // don't input into database if field is empty
        if (mExercise.isEmpty()) {
            return;
        }
        GymLog log = new GymLog(mExercise, mWeight, mReps, loggedInUserId);
        repository.insertGymLog(log);
    }

    /**
     * A method to access data inside database & display it on screen.
     */
    private void updateDisplay() {
        // accessing db
        ArrayList<GymLog> allLogs = repository.getAllLogs();
        if (allLogs.isEmpty()) {
            binding.logDisplayTextView.setText(R.string.nothing_to_show_time_to_hit_the_gym);
        }
        StringBuilder sb = new StringBuilder();
        for (GymLog log : allLogs) {
            sb.append(log);
        }
        binding.logDisplayTextView.setText(sb.toString());
    }

    private void getInformationFromDisplay() {
        mExercise = binding.exerciseInputEditText.getText().toString();

        // parseDouble throws numberFormatException -> needs try catch
        try {
            mWeight = Double.parseDouble(binding.weightInputEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d(TAG, "Error reading value from Weight Edit Text.");
        }

        // parseInt throws numberFormatException -> needs try catch
        try {
            mReps = Integer.parseInt(binding.repInputEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d(TAG, "Error reading value from Reps Edit Text.");
        }
    }
}