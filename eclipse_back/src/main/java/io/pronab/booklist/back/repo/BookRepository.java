package io.pronab.booklist.back.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.pronab.booklist.back.model.Book;
import io.pronab.booklist.back.model.Person;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByBorrowedby(String email);
}
