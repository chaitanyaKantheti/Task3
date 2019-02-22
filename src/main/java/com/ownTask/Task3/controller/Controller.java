package com.ownTask.Task3.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;

import com.ownTask.Task3.models.Project;
import com.ownTask.Task3.models.Stage;
import com.ownTask.Task3.models.Task;
import com.ownTask.Task3.services.ProjectServicesInterface;

@RestController
public class Controller {
	
	@Autowired
	ProjectServicesInterface projectServicesInterface;
	
	@Value("${spring.datasource.driver-class-name}")
	public String DB_DRIVER;
	
	
	@RequestMapping(value="/greet")	
	public String greet() {
		System.out.println(DB_DRIVER);
		return ("Hello world"+DB_DRIVER);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/addProject")
	public String addProject(@RequestBody Project project) {
		return projectServicesInterface.addProject(project);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/projects")
	public List<Project> getProjects(){
		return projectServicesInterface.getProjects();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/projects/{pId}")
	public Project getAProject(@PathVariable String pId){
		return projectServicesInterface.getAProject(pId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/projects/{pId}/addTask")
	public String addTask(@RequestBody Task task,@PathVariable String pId) {
		return projectServicesInterface.addTask(task,pId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/projects/{pId}/tasks")
	public List<Task> getTasks(@PathVariable String pId){
		return projectServicesInterface.getTasks(pId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/projects/{pId}/tasks/{tId}/addStage")
	public String addStage(@RequestBody Stage stage,@PathVariable String pId,@PathVariable String tId) {
		return projectServicesInterface.addStage(stage,pId,tId);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/projects/tasks/{tId}/stages")
	public List<Stage> getStages(@PathVariable String tId){
		return projectServicesInterface.getStages(tId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/fileUpload")
	public String checkFile(@RequestParam("file") MultipartFile file){   
		String name = file.getOriginalFilename();
		System.out.println(">>>>>>>>>>>"+name);
		int lastIndexOf = name.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return ""; // empty extension
		}
		String result=name.substring(lastIndexOf);
		return result;
		//return null;
	}
	
}
