package com.ownTask.Task3.services;

import java.util.List;

import com.own.Task.Task3.exception.Task3Exception;
import com.ownTask.Task3.models.Project;
import com.ownTask.Task3.models.Stage;
import com.ownTask.Task3.models.Task;

public interface ProjectServicesInterface {

	public String addProject(Project project);
	
	public String addTask(Task task, String pId);

	public List<Project> getProjects();

	public List<Task> getTasks(String pId);

	public String addStage(Stage stage, String pId, String tId);

	public List<Stage> getStages(String tId);

	public Project getAProject(String pId);

	

}
