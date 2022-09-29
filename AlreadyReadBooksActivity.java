package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class AlreadyReadBooksActivity extends AppCompatActivity {

    RecyclerView alreadyReadRecView;
    TextView warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();

        AllBooksRecyclerViewAdapter adapter = new AllBooksRecyclerViewAdapter(this,"AlreadyReadBooksActivity");
        adapter.setAllBooks(Utils.getInstance().getReadBooks());
        alreadyReadRecView.setAdapter(adapter);

        alreadyReadRecView.setLayoutManager(new LinearLayoutManager(this));

        if (Utils.getInstance().getReadBooks().isEmpty()) {
            warning.setText("Nothing Added Yet!");
        }

    }

    private void initialize() {
        alreadyReadRecView = findViewById(R.id.alreadyReadRecView);
        warning = findViewById(R.id.warningAlreadyRead);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AlreadyReadBooksActivity.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}