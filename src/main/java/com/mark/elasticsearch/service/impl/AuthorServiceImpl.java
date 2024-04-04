package com.mark.elasticsearch.service.impl;

import com.mark.elasticsearch.model.Author;
import com.mark.elasticsearch.repository.AuthorRepository;
import com.mark.elasticsearch.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(String id, Author author) {
        Optional<Author> existingAuthor = authorRepository.findById(id);
        if (existingAuthor.isPresent()) {
            Author savedAuthor = existingAuthor.get();
            savedAuthor.setName(author.getName());
            savedAuthor.setAge(author.getAge());
            return authorRepository.save(savedAuthor);
        } else {
            throw new ResourceNotFoundException("Author not found with id " + id);
        }
    }

    @Override
    public Author getAuthorById(String id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            return author.get();
        } else {
            throw new ResourceNotFoundException("Author not found with id " + id);
        }
    }

    @Override
    public void deleteAuthor(String id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            authorRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Author not found with id " + id);
        }
    }
}
