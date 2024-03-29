package com.jareer.bookshopwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDetailsDTO {
    private Integer id;
    private String title;
    private String author;
    private String description;
    private int views;
    private int likes;
    private int dislikes;
    private int downloads;
    private String category;
    private String publisher;
    private LocalDateTime publishedDate;
    private String coverOriginalFileName;
    private String coverGeneratedFileName;
    private String coverFileSize;
    private String documentOriginalFileName;
    private String documentGeneratedFileName;
    private String documentFileSize;
}
