package com.mark.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(indexName = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String description;
}