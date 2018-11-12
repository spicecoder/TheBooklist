package io.pronab.booklist.back.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import io.pronab.booklist.back.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
}
