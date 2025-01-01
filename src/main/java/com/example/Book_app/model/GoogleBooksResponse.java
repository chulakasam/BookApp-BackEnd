package com.example.Book_app.model;

import java.util.List;

public class GoogleBooksResponse {
    private List<Book> items;

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }

}
