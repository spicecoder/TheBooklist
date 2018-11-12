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
import io.pronab.booklist.back.repo.PersonRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonRepository repository;

	@GetMapping("/people")
	public List<Person> getAllPeople() {
		System.out.println("all the people...");

		List<Person> people = new ArrayList<>();
		repository.findAll().forEach(people::add);

		return people;
	}
	@PostMapping("/person")
	public Person postBookr(@RequestBody Person person) {

		Person _person = repository.save(new Person(person.getName(), person.getPhone(),person.getEmail()));
		return _person;
	}
	

	
}
