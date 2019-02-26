package com.ownTask.Task3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.own.Task.Task3.exception.Task3Exception;
import com.ownTask.Task3.models.Person;
import com.ownTask.Task3.models.ResponseObject;
import com.ownTask.Task3.services.PersonServiceInterface;

@RestController
public class PController {
	
	@Autowired
	private PersonServiceInterface personServiceInterface;
	
	@GetMapping(value="/hello")
	public ResponseEntity<ResponseObject> helloWorld() {
		ResponseObject response=new ResponseObject();
		response.setStatus("Success");
		response.setResponse("Hello world");
		return new ResponseEntity<ResponseObject>(response,HttpStatus.OK);
	}
	
	@PostMapping(value="/saveData")
	public ResponseEntity<ResponseObject> savePersonData(@RequestBody Person person) {
		ResponseObject responseObject=new ResponseObject();
		Person savedPerson=personServiceInterface.saveData(person);
		if(savedPerson!=null) {
			responseObject.setStatus("Success");
			responseObject.setResponse("Data Saved");
			return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.OK);
		}
		responseObject.setStatus("Failed");
		responseObject.setResponse("Data is not saved");
		return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value="/findPerson/{id}")
	public ResponseEntity<ResponseObject> findData(@PathVariable int id) {
		ResponseObject responseObject=new ResponseObject();
		Optional<Person> person=personServiceInterface.findById(id);
		if(person!=null) {
			responseObject.setStatus("Success");
			responseObject.setResponse(person);
			return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.OK);
		}
		responseObject.setStatus("Failed");
		responseObject.setResponse("Data retrieval failed");
		return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/saveBulkData")
	public String saveBulkData(@RequestBody List<Person> persons) {
		personServiceInterface.saveBulkData(persons);
		return "Data saved";
	}
	
	@GetMapping(value="/findAll")
	public ResponseEntity<ResponseObject> findAll() {
		ResponseObject responseObject=new ResponseObject();
		List<Person> persons=personServiceInterface.findAll();
		if(persons!=null) {
			responseObject.setStatus("Success");
			responseObject.setResponse(persons);
			return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.OK);
		}
		responseObject.setStatus("Failed");
		responseObject.setResponse("Data retrieval failed");
		return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value="/updatePersonById/{id}")
	public ResponseEntity<ResponseObject> updatePersonById(@RequestBody Person person,@PathVariable int id) throws Task3Exception {
		ResponseObject responseObject=new ResponseObject();
		Person updatedPerson=personServiceInterface.updateData(person,id);
		if(updatedPerson!=null) {
			responseObject.setStatus("Success");
			responseObject.setResponse(updatedPerson);
			return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.OK);
		}
		responseObject.setStatus("Failed");
		responseObject.setResponse("updation failed");
		return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@DeleteMapping(value="/deletePerson/{id}")
	public ResponseEntity<ResponseObject> deletePersonById(@PathVariable int id) throws Task3Exception {
		ResponseObject responseObject=new ResponseObject();
		Boolean status=personServiceInterface.deleteById(id);
		if(status) {
			responseObject.setStatus("Success");
			responseObject.setResponse("Deleted Successfully");
			return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.OK);
		}
		responseObject.setStatus("Failed");
		responseObject.setResponse("Deletion failed");
		return new ResponseEntity<ResponseObject>(responseObject,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
