package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button allBooks, currentlyReadingBooks, finishedBooks, myFavorites, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialize();

        allBooks.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, AllBooksActivity.class);
            startActivity(intent);
        });

        currentlyReadingBooks.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, CurrentlyReadingActivity.class);
            startActivity(intent);
        });

        finishedBooks.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, FinishedBooksActivity.class);
            startActivity(intent);
        });

        myFavorites.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, MyFavoritesActivity.class);
            startActivity(intent);
        });

        about.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, AboutActivity.class);
            startActivity(intent);
        });
    }

    private void initialize() {
        allBooks = findViewById(R.id.allBooksButton);
        currentlyReadingBooks = findViewById(R.id.currentlyReadingButton);
        finishedBooks = findViewById(R.id.finishedBooksButton);
        myFavorites = findViewById(R.id.myFavoritesButton);
        about = findViewById(R.id.aboutButton);
    }
}