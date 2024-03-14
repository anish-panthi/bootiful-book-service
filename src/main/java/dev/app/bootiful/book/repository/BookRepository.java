package dev.app.bootiful.book.repository;

import dev.app.bootiful.book.dto.Book;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final JdbcClient jdbcClient;

    public BookRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Book> findAll(){
        return jdbcClient.sql("SELECT * FROM books").query(Book.class).stream().toList();
    }
}
