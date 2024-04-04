package com.mark.elasticsearch.repository;

import com.mark.elasticsearch.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
