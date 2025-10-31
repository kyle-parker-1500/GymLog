package com.example.hw04_gymlog_v300;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw04_gymlog_v300.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }

    static Intent loginIntentFactory(Context context) {
        return new Intent(context, LoginActivity.class);
    }
}