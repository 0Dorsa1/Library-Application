package com.example.library;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    public static Utils getInstance() {
        if (instance==null){
            instance=new Utils();
        }
        return instance;
    }

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> favorites;
    private static ArrayList<Book> readBooks;
    private static ArrayList<Book> wishList;
    private static ArrayList<Book> currentlyReading;

    public Utils() {
        if (allBooks==null){
            allBooks=new ArrayList<>();
            initData();
        }
        if (favorites==null){
            favorites=new ArrayList<>();
        }
        if (readBooks==null){
            readBooks=new ArrayList<>();
        }
        if (wishList==null){
            wishList=new ArrayList<>();
        }
        if (currentlyReading==null){
            currentlyReading=new ArrayList<>();
        }
    }

    private void initData(){
        allBooks.add(new Book(1, 224, "The Subtle Art Of Not Giving A F*ck", "Mark Manson", "https://kbimages1-a.akamaihd.net/f68de379-e763-441c-8159-a949ea575237/1200/1200/False/the-subtle-art-of-not-giving-a-f-ck.jpg", " A Counterintuitive Approach to Living a Good Life is a 2016 nonfiction self-help book by American blogger and author Mark Manson.", "Long Description", "Mark Manson is the New York Times bestselling author of The Subtle Art of Not Giving a F*ck (more than ten million copies sold worldwide) and a star blogger."));
        allBooks.add(new Book(2, 304, "No Excuses!: The Power Of Self-Discipline", "Brian Tracy", "https://images-na.ssl-images-amazon.com/images/I/81Hz0P6u5TL.jpg", "You don't need to have been born under a lucky star, or with incredible wealth, or with terrific contacts and connections, or even special skills...but what you do need to succeed in any of your life goals is self-discipline", "Long Description", "Brian Tracy is a Canadian-American motivational public speaker and self-development author."));
        allBooks.add(new Book(3,306,"Atomic Habits: An Easy & Proven Way To Build Good Habits & Break Bad Ones","James Clear","https://images-na.ssl-images-amazon.com/images/I/81E7fYJuiTL.jpg","A supremely practical and useful book. James Clear distills the most fundamental information about habit formation, so you can accomplish more by focusing on less.","Long Description","James Clear is a writer and speaker focused on habits, decision making, and continuous improvement. He is the author of the no. 1 New York Times bestseller, Atomic Habits."));
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getFavorites() {
        return favorites;
    }

    public static ArrayList<Book> getReadBooks() {
        return readBooks;
    }

    public static ArrayList<Book> getWishList() {
        return wishList;
    }

    public static ArrayList<Book> getCurrentlyReading() {
        return currentlyReading;
    }

    public Book getBookById(int id){
        for (Book book: allBooks
             ) {
            if (book.getId()==id){
                return book;
            }
        }
        return null;
    }

    public boolean addToAlreadyReadBooks(Book book){
        return readBooks.add(book);
    }

    public boolean addToCurrentlyReadingBooks(Book book){
        return currentlyReading.add(book);
    }

    public boolean addToWishList(Book book){
        return wishList.add(book);
    }

    public boolean addToFavorites(Book book){
        return favorites.add(book);
    }

    public boolean removeFromAlreadyReadBooks(Book book){
        return readBooks.remove(book);
    }

    public boolean removeFromCurrentlyReadingBooks(Book book){
        return currentlyReading.remove(book);
    }

    public boolean removeFromWishList(Book book){
        return wishList.remove(book);
    }

    public boolean removeFromFavorites(Book book){
        return favorites.remove(book);
    }


}
