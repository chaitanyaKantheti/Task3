package com.ownTask.Task3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.own.Task.Task3.exception.Task3Exception;
import com.ownTask.Task3.models.Person;
import com.ownTask.Task3.repository.PersonsRepository;

@Service
public class PersonServiceImpl implements PersonServiceInterface {

	@Autowired
	PersonsRepository personRepository;
	
	@Override
	public Person saveData(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Optional<Person> findById(int id) {
		return personRepository.findById(id);
	}

	@Override
	public void saveBulkData(List<Person> persons) {
		personRepository.saveAll(persons);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person updateData(Person person, int id) throws Task3Exception {
		Optional<Person> savedPerson=personRepository.findById(id);
		if(savedPerson.isPresent()) {
			/*person.setId(id);
			personRepository.save(person);*/
			personRepository.updatePerson(id,person.getFirstName(),person.getLastName(),person.getAge());
		}
		else {
			throw new Task3Exception("Person with the given id is not present");
		}
		return person;
		
	}

	@Override
	public Boolean deleteById(int id) {
		 personRepository.deleteById(id);
		 Optional<Person> person=personRepository.findById(id);
		 if(person!=null) {
			 return false;
		 }
		 return true;
	}

}
