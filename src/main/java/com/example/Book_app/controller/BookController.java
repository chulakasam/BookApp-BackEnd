package com.example.Book_app.controller;

import com.example.Book_app.model.Book;
import com.example.Book_app.model.GoogleBooksResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:63342")
public class BookController {
    private final String GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes";

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String query) {
        RestTemplate restTemplate = new RestTemplate();
        String url = GOOGLE_BOOKS_API_URL + "?q=" + query + "&maxResults=10";
        ResponseEntity<GoogleBooksResponse> response = restTemplate.getForEntity(url, GoogleBooksResponse.class);

        return response.getBody().getItems();
    }

}
