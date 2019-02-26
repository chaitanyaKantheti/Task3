package com.ownTask.Task3.services;

import java.util.List;
import java.util.Optional;

import com.own.Task.Task3.exception.Task3Exception;
import com.ownTask.Task3.models.Person;

public interface PersonServiceInterface {
	Person saveData(Person person);

	Optional<Person> findById(int id);

	void saveBulkData(List<Person> persons);

	List<Person> findAll();

	Person updateData(Person person, int id) throws Task3Exception;

	Boolean deleteById(int id);
}
