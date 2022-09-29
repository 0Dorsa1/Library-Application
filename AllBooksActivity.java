package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.InflateException;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    RecyclerView allBooksRecyclerView;
    AllBooksRecyclerViewAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_all_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        booksAdapter = new AllBooksRecyclerViewAdapter(this,"AllBooksActivity");

        allBooksRecyclerView = findViewById(R.id.allBooksRecyclerView);

        allBooksRecyclerView.setAdapter(booksAdapter);

        allBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> allBooks = new ArrayList<>();
        allBooks.add(new Book(1, 224, "The Subtle Art Of Not Giving A F*ck", "Mark Manson", "https://kbimages1-a.akamaihd.net/f68de379-e763-441c-8159-a949ea575237/1200/1200/False/the-subtle-art-of-not-giving-a-f-ck.jpg", " A Counterintuitive Approach to Living a Good Life is a 2016 nonfiction self-help book by American blogger and author Mark Manson.", "Long Description", "Mark Manson is the New York Times bestselling author of The Subtle Art of Not Giving a F*ck (more than ten million copies sold worldwide) and a star blogger."));
        allBooks.add(new Book(2, 304, "No Excuses!: The Power Of Self-Discipline", "Brian Tracy", "https://images-na.ssl-images-amazon.com/images/I/81Hz0P6u5TL.jpg", "You don't need to have been born under a lucky star, or with incredible wealth, or with terrific contacts and connections, or even special skills...but what you do need to succeed in any of your life goals is self-discipline", "Long Description", "Brian Tracy is a Canadian-American motivational public speaker and self-development author."));
        allBooks.add(new Book(3, 306, "Atomic Habits: An Easy & Proven Way To Build Good Habits & Break Bad Ones", "James Clear", "https://images-na.ssl-images-amazon.com/images/I/81E7fYJuiTL.jpg", "A supremely practical and useful book. James Clear distills the most fundamental information about habit formation, so you can accomplish more by focusing on less.", "Long Description", "James Clear is a writer and speaker focused on habits, decision making, and continuous improvement. He is the author of the no. 1 New York Times bestseller, Atomic Habits."));
        booksAdapter.setAllBooks(Utils.getInstance().getAllBooks());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AllBooksActivity.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}