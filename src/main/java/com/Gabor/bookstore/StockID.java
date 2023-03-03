package com.Gabor.bookstore;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StockID implements Serializable {

    private Long storeId;
    private Long bookId;
}
