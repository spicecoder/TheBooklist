package io.pronab.booklist.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	// title, author and ISBN.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "isbn")
	private String isbn;

	@Column(name = "borrowedby")
	private String borrowedby;

	
	public Book() {
	}

	public Book(String title, String author, String isbn,String borrowedby ) {
		this.title = title;
		this.author = author;
		this.isbn= isbn;
		this.borrowedby = borrowedby;
	}

	public long getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title =title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setIsbn(String isbn) {
		this.isbn= isbn;
	}
	public String getIsbn() {
		return  this.isbn;
	}

	public String getAuthor() {
		return this.author;
	}
	public void settAuthor(String author) {
		this.author = author;
	}

	
	public String getBorrowedby() {
		return this.borrowedby;
	}
	
	public void  settBorroedby(String borrowedby) {
		  this.borrowedby = borrowedby ;
	}
	 

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" +title + ", author=" + author + ", ISBN=" + isbn + ", borrowedby=" + borrowedby + "]";
	}
}
