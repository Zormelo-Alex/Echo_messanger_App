package com.example.messageme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.messageme.R;
import com.example.messageme.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignInBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        setListeners();

    }
    private void setListeners(){
        binding.textcreateNewAccount.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
        });
    }
}