package com.ownTask.Task3.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ownTask.Task3.models.Person;

@Repository
public interface PersonsRepository extends JpaRepository<Person,Integer> {

	@Modifying
	@Transactional
	@Query("update Person person set person.firstName=:firstName,person.lastName=:lastName,person.age=:age where person.id=:id")
	void updatePerson(@Param("id") int id,@Param("firstName") String firstName,@Param("lastName") String lastName, 
			@Param("age")int age);
	
	
	
}
