package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookClick extends AppCompatActivity {

    ImageView bookImg;
    Button currentlyReadingBtn, addToFavoritesBtn, addToWishListBtn, addToReadBtn, backBtn;
    TextView bookName, authorName, numberOfPages, longDescription, aboutAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_click);

        initialize();

        Intent intent = getIntent();

        if (intent != null) {
            int bookId = intent.getIntExtra("bookId", -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (incomingBook != null) {
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleCurrentlyReading(incomingBook);
                    handleWishList(incomingBook);
                    handleFavorites(incomingBook);
                }
            }
        }

        backBtn.setOnClickListener(view -> {
            Intent intent1 = new Intent(BookClick.this, AllBooksActivity.class);
            startActivity(intent1);
        });
    }

    private void initialize() {
        bookImg = findViewById(R.id.bookImg);
        currentlyReadingBtn = findViewById(R.id.currentlyReadingBtn);
        addToFavoritesBtn = findViewById(R.id.addToFavoritesBtn);
        addToWishListBtn = findViewById(R.id.addToWishListBtn);
        addToReadBtn = findViewById(R.id.alreadyReadBtn);
        backBtn = findViewById(R.id.backBtn);
        bookName = findViewById(R.id.bookName);
        authorName = findViewById(R.id.authorName);
        numberOfPages = findViewById(R.id.numberOfPages);
        longDescription = findViewById(R.id.longDescription);
        aboutAuthor = findViewById(R.id.aboutAuthor);

    }


    protected void setData(Book book) {
        Glide.with(this).asBitmap().load(book.getImageURL()).into(bookImg);
        bookName.setText(book.getName());
        authorName.setText(book.getAuthor());
        numberOfPages.setText(String.valueOf(book.getNumberOgPages()));
        longDescription.setText(book.getLongDescription());
        aboutAuthor.setText(book.getAboutAuthor());
    }

    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getReadBooks();
        boolean existsInAlreadyReadBooks = false;
        for (Book b : alreadyReadBooks) {
            if (b.getId() == book.getId()) {
                existsInAlreadyReadBooks = true;
                break;
            }
        }
        if (existsInAlreadyReadBooks) {
            addToReadBtn.setEnabled(false);
        } else {
            addToReadBtn.setOnClickListener(view -> {
                if (Utils.getInstance().addToAlreadyReadBooks(book)) {
                    Toast.makeText(BookClick.this, book.getName() + "Successfully Added To Your Read Books.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(BookClick.this, AlreadyReadBooksActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(BookClick.this, "Something Went Wrong... Please Try Again Later.", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void handleCurrentlyReading(Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReading();
        boolean existsInCurrentlyReadingBooks = false;
        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existsInCurrentlyReadingBooks = true;
                break;
            }
        }

        if (existsInCurrentlyReadingBooks) {
            currentlyReadingBtn.setEnabled(false);
        } else {
            currentlyReadingBtn.setOnClickListener(view -> {
                if (Utils.getInstance().addToCurrentlyReadingBooks(book)) {
                    Toast.makeText(BookClick.this, book.getName() + " Successfully Added To Currently Reading Books.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(BookClick.this, CurrentlyReadingActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(BookClick.this, "Something Went Wrong... Please Try Again Later.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void handleWishList(Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getWishList();
        boolean existsInWishList = false;
        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existsInWishList = true;
                break;
            }
        }

        if (existsInWishList) {
            addToWishListBtn.setEnabled(false);
        } else {
            addToWishListBtn.setOnClickListener(view -> {
                if (Utils.getInstance().addToWishList(book)) {
                    Toast.makeText(BookClick.this, book.getName() + " Successfully Added To Your Wish List.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(BookClick.this, WishListActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(BookClick.this, "Something Went Wrong... Please Try Again Later.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void handleFavorites(Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getFavorites();
        boolean existsInFavorites = false;
        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existsInFavorites = true;
                break;
            }
        }

        if (existsInFavorites) {
            addToFavoritesBtn.setEnabled(false);
        } else {
            addToFavoritesBtn.setOnClickListener(view -> {
                if (Utils.getInstance().addToFavorites(book)) {
                    Toast.makeText(BookClick.this, book.getName() + " Successfully Added To Your Favorites.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(BookClick.this, MyFavoritesActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(BookClick.this, "Something Went Wrong... Please Try Again Later.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BookClick.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}