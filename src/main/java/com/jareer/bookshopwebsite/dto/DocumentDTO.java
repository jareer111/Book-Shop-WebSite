package com.jareer.bookshopwebsite.dto;

public record DocumentDTO(Integer id, String generatedFileName, String originalFileName, String mimeType, String filePath, String extension, Long fileSize) implements DTO {
}
