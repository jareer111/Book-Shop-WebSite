package com.jareer.bookshopwebsite.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private LocalDateTime createdAt;
    private LocalDateTime publishedDate;
    private String description;
    private int downloads;
    private int views;
    private int likes;
    private int dislikes;
    private int categoryId;
    private boolean deleted;
    private int coverId;
    private int documentId;
}
