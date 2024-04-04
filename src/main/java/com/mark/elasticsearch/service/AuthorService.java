package com.mark.elasticsearch.service;

import com.mark.elasticsearch.model.Author;

public interface AuthorService {
    Author createAuthor(Author author);
    Author updateAuthor(String id, Author author);
    Author getAuthorById(String id);
    void deleteAuthor(String id);
}
