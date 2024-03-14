package dev.app.bootiful.book.repository;

import dev.app.bootiful.book.dto.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookInMemoryRepository {

  private final List<Book> books = new ArrayList<>();

  @PostConstruct
  private void init() {
    books.add(new Book(1L, "Java", "James Gosling", "Java Programming", "1995-05-23"));
    books.add(new Book(2L, "Python", "Guido van Rossum", "Python Programming", "2005-02-20"));
    books.add(new Book(3L, "C++", "Bjarne Stroustrup", "C++ Programming", "2000-10-14"));
  }

  public List<Book> findAll() {
    return books;
  }

  public Optional<Book> findById(Long id) {
    return books.stream().filter(b -> b.id().equals(id)).findFirst();
  }

  public void save(Book book){
    books.removeIf(b -> b.id().equals(book.id()));
    books.add(book);
  }

  public void delete(Book book){
    books.removeIf(b -> b.id().equals(book.id()));
  }
}
