package com.example.com.nest.LibraryApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BooksModel {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String image;
    private String description;
    private String releasedyear;
    private String price;
    private String author;

    public BooksModel() {
    }

    public BooksModel(int id, String title, String image, String description, String releasedyear, String price, String author) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.releasedyear = releasedyear;
        this.price = price;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleasedyear() {
        return releasedyear;
    }

    public void setReleasedyear(String releasedyear) {
        this.releasedyear = releasedyear;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}