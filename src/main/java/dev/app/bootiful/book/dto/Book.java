package dev.app.bootiful.book.dto;

import java.time.LocalDate;

public record Book(
    Integer id, String title, String author, String description, String publishedDate) {}
