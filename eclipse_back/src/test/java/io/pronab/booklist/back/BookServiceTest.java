package io.pronab.booklist.back;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.pronab.booklist.back.controller.BookController;
import io.pronab.booklist.back.model.Book;
import io.pronab.booklist.back.repo.BookRepository;

public class BookServiceTest {
	
	private BookRepository repository;
	 
	
	@Before
	public void prepare() {
		repository = mock(BookRepository.class);
		 
	}
	//To do : fix surefire plugin
	@Test
	public void findBuddyTest() {
	    List<Book> books = new ArrayList<Book>();
	    
	    Book b1 = new Book();
	   
	    b1.setTitle("John Went To Hollywood");
	    b1.setAuthor("Liberal Jones");
	     
	    books.add(b1);
	    
	    
	    Mockito.when(repository.findAll()).thenReturn(books);
	    BookController bc = new BookController();
	    
	  //  assert(bc.getAllBooks().contains(b1));
	}
}