package com.Gabor.bookstore;

import jakarta.persistence.*;

@Entity
public class Stock {

    @EmbeddedId
    private StockID stockId;

    private int quantity;


    public StockID getStockId() {
        return stockId;
    }

    public void setStockId(StockID stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
