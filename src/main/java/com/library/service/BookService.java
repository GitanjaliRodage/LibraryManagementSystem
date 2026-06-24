package com.library.service;

import com.library.entity.Book;
import com.library.exception.BookNotFoundException;
import com.library.exception.DuplicateISBNException;
import com.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    // CREATE
    public Book addBook(Book book) {

        if (repository.findByIsbn(book.getIsbn()).isPresent()) {
            throw new DuplicateISBNException("ISBN already exists!");
        }

        book.setAvailable(true);
        book.setCopies(book.getQuantity());

        return repository.save(book);
    }

    // READ ALL
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // READ BY ID
    public Book getBookById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    // UPDATE
    public Book updateBook(UUID id, Book updated) {

        Book existing = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        existing.setBookName(updated.getBookName());
        existing.setAuthor(updated.getAuthor());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());
        existing.setIsbn(updated.getIsbn());
        existing.setCopies(updated.getQuantity());

        return repository.save(existing);
    }

    // DELETE
    public void deleteBook(UUID id) {

        Book existing = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        repository.delete(existing);
    }
}