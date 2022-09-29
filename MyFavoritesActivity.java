package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MyFavoritesActivity extends AppCompatActivity {

    TextView warning;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorites);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();

        AllBooksRecyclerViewAdapter adapter = new AllBooksRecyclerViewAdapter(this,"MyFavoritesActivity");
        adapter.setAllBooks(Utils.getInstance().getFavorites());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (Utils.getInstance().getFavorites().isEmpty()) {
            warning.setText("Nothing Added Yet!");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MyFavoritesActivity.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initialize() {
        warning = findViewById(R.id.warningFavorites);
        recyclerView = findViewById(R.id.myFavoritesRecView);
    }
}