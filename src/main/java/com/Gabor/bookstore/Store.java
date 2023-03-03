package com.Gabor.bookstore;

import jakarta.persistence.*;
import java.util.List;



@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String network;

    @ManyToMany
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Store{");
        sb.append("id=").append(id);
        sb.append(", network='").append(network).append('\'');
        sb.append(", books=").append(books);
        sb.append('}');
        return sb.toString();
    }
}
