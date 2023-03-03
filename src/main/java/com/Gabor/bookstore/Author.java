package com.Gabor.bookstore;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameAuthor;

    private String date;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(id);
        sb.append(", nameAuthor='").append(nameAuthor).append('\'');
        sb.append(", date=").append(date);
        sb.append(", books=").append(books);
        sb.append('}');
        return sb.toString();
    }
}
