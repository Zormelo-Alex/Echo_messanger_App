package com.example.messageme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.messageme.databinding.ActivityChatBinding;
import com.example.messageme.models.User;
import com.example.messageme.utilities.Constants;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private User recieverUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        loadRecieverDetails();
    }
    private void loadRecieverDetails(){
        recieverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
        binding.textName.setText(recieverUser.name);
    }

    private void setListeners(){
        binding.imageBack.setOnClickListener(v -> onBackPressed());
    }
}