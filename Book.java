package com.example.library;

public class Book {
    private int id, numberOgPages;
    private String name, author, imageURL, shortDescription, longDescription, aboutAuthor;
    private boolean isExpanded;

    public Book(int id, int numberOgPages, String name, String author, String imageURL, String shortDescription, String longDescription,String aboutAuthor) {
        this.id = id;
        this.numberOgPages = numberOgPages;
        this.name = name;
        this.author = author;
        this.imageURL = imageURL;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.aboutAuthor=aboutAuthor;
        isExpanded=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOgPages() {
        return numberOgPages;
    }

    public void setNumberOgPages(int numberOgPages) {
        this.numberOgPages = numberOgPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public String getAboutAuthor() {
        return aboutAuthor;
    }

    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", numberOgPages=" + numberOgPages +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", aboutAuthor='" + aboutAuthor + '\'' +
                ", isExpanded=" + isExpanded +
                '}';
    }
}
