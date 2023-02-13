package com.jareer.bookshopwebsite.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedAt;
    private int pages;
    private int downloads;
    private int views;
    private int likes;
    private int dislikes;
    private String category;
    private boolean deleted;
    private Integer coverId;
    private Integer documentId;
}
