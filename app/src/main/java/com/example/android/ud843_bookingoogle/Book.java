package com.example.android.ud843_bookingoogle;

public class Book {
    private Double mAverageRating;

    private String mTitle;

    private Double mRetailPrice;

    private String mPublishedDate;

    private String mInfolink;

    public Book(Double averageRating, String title, Double retailPrice, String publishedDate, String infolink) {
        this.mAverageRating = averageRating;
        this.mTitle = title;
        this.mRetailPrice = retailPrice;
        this.mPublishedDate = publishedDate;
        this.mInfolink = infolink;
    }

    public Double getAverageRating() {
        return mAverageRating;
    }

    public String getTitle() {
        return mTitle;
    }

    public Double getRetailPrice() {
        return mRetailPrice;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public String getInfolink() {
        return mInfolink;
    }
}
