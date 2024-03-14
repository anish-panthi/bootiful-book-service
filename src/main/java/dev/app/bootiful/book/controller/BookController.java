package dev.app.bootiful.book.controller;

import dev.app.bootiful.book.dto.Book;
import dev.app.bootiful.book.repository.BookInMemoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookInMemoryRepository bookRepository;

    public BookController(BookInMemoryRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/books")
    public void saveBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @PutMapping("/api/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable Integer id) {
        bookRepository.save(book);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookRepository.findById(id).ifPresent(bookRepository::delete);
    }
}
