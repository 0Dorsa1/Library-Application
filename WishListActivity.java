package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class WishListActivity extends AppCompatActivity {

    TextView warning;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();

        AllBooksRecyclerViewAdapter adapter = new AllBooksRecyclerViewAdapter(this,"WishListActivity");
        adapter.setAllBooks(Utils.getInstance().getWishList());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (Utils.getInstance().getWishList().isEmpty()) {
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
        Intent intent = new Intent(WishListActivity.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initialize() {
        warning = findViewById(R.id.warningWishList);
        recyclerView=findViewById(R.id.wishListRecView);
    }
}