package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class CurrentlyReadingActivity extends AppCompatActivity {

    TextView warning;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();

        if (Utils.getInstance().getCurrentlyReading().isEmpty()) {
            warning.setText("Nothing Added Yet!");
        }

        AllBooksRecyclerViewAdapter adapter=new AllBooksRecyclerViewAdapter(this,"CurrentlyReadingBooksActivity");
        adapter.setAllBooks(Utils.getInstance().getCurrentlyReading());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CurrentlyReadingActivity.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initialize() {
        warning = findViewById(R.id.warningCurrently);
        recyclerView=findViewById(R.id.currentlyReadingRecView);
    }
}