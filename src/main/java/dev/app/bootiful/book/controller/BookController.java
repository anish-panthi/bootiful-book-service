package dev.app.bootiful.book.controller;

import dev.app.bootiful.book.dto.Book;
import dev.app.bootiful.book.repository.BookInMemoryRepository;
import dev.app.bootiful.book.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

//    @GetMapping("/api/books/{id}")
//    public Book getBookById(@PathVariable("id") Long id) {
//        return bookRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping("/api/books")
//    public void saveBook(@RequestBody Book book) {
//        bookRepository.save(book);
//    }
//
//    @PutMapping("/api/books/{id}")
//    public void updateBook(@RequestBody Book book, @PathVariable Integer id) {
//        bookRepository.save(book);
//    }
//
//    @DeleteMapping("/api/books/{id}")
//    public void deleteBook(@PathVariable Long id) {
//        bookRepository.findById(id).ifPresent(bookRepository::delete);
//    }
}
