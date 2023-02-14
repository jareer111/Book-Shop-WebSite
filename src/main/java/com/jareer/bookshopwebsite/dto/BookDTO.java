package com.jareer.bookshopwebsite.dto;

public record BookDTO(Integer id, String name, String author, String description, Integer categoryId) implements DTO{
}
