package io.pronab.booklist.back.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pronab.booklist.back.model.Book;
import io.pronab.booklist.back.model.Person;
import io.pronab.booklist.back.repo.BookRepository;
import io.pronab.booklist.back.repo.PersonRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookRepository repository;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		System.out.println("all the books...");

		List<Book> books = new ArrayList<>();
		repository.findAll().forEach(books::add);

		return books;
	}
	@GetMapping("books/borrowedby/{email}")
	public List<Book> findByBorrowedby(@PathVariable String email) {

		List<Book> books = repository.findByBorrowedby(email);
		return books;
	}
	@PostMapping("/book")
	public Book postBookr(@RequestBody Book book) {

		Book _book = repository.save(new Book(book.getTitle(), book.getAuthor(),book.getIsbn(),book.getBorrowedby()));
		return _book;
	}

	
}
