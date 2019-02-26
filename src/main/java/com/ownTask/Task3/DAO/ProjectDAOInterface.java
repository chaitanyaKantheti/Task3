package com.ownTask.Task3.DAO;


import java.util.List;


import com.ownTask.Task3.models.Project;
import com.ownTask.Task3.models.Stage;
import com.ownTask.Task3.models.Task;

public interface ProjectDAOInterface {

	public String addProject(Project project);

	public String addTask(Task task, String pId);

	public List<Project> getProjects();

	public List<Task> getTasks(String pId);

	public String addStage(Stage stage, String pId, String tId);

	public List<Stage> getStages(String tId);

	public Project getAProject(String pId);


}
