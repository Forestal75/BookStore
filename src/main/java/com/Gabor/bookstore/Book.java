package com.Gabor.bookstore;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String title;

    private String isbn;

    @OneToMany
    @JoinTable(
            name = "Stock",
            joinColumns = @JoinColumn(name = "BookId"),
            inverseJoinColumns = @JoinColumn(name = "StoreId")
    )

    private List<Store> inStockAt;

    private boolean onLine;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Store> getInStockAt() {
        return inStockAt;
    }

    public void setInStockAt(List<Store> inStockAt) {
        this.inStockAt = inStockAt;
    }

    public boolean isOnLine() {
        return onLine;
    }

    public void setOnLine(boolean onLine) {
        this.onLine = onLine;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", author='").append(author).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", inStockAt=").append(inStockAt);
        sb.append(", onLine=").append(onLine);
        sb.append('}');
        return sb.toString();
    }
}
