package com.mark.elasticsearch.service.impl;

import com.mark.elasticsearch.model.Book;
import com.mark.elasticsearch.repository.BookRepository;
import com.mark.elasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(String id, Book book) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book savedBook = existingBook.get();
            savedBook.setTitle(book.getTitle());
            savedBook.setAuthor(book.getAuthor());
            savedBook.setDescription(book.getDescription());
            return bookRepository.save(savedBook);
        } else {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
    }

    @Override
    public Book getBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
    }

    @Override
    public void deleteBook(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
    }
}