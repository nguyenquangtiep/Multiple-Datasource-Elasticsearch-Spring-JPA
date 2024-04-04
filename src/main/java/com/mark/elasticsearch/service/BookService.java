package com.mark.elasticsearch.service;

import com.mark.elasticsearch.model.Book;

public interface BookService {
    Book createBook(Book book);
    Book updateBook(String id, Book book);
    Book getBookById(String id);
    void deleteBook(String id);
}
