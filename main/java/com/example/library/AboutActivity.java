package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        back=findViewById(R.id.backButton);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(AboutActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}