package dev.app.bootiful.book.dto;

import java.time.LocalDate;

public record Book(
    Long id, String title, String author, String description, String publishedDate) {}
