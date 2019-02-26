package com.ownTask.Task3.services;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ownTask.Task3.DAO.ProjectDAOInterface;
import com.ownTask.Task3.models.Project;
import com.ownTask.Task3.models.Stage;
import com.ownTask.Task3.models.Task;


@Service
public class PojectServicesImpl implements ProjectServicesInterface {
	
	@Autowired
	ProjectDAOInterface projectDaoInterface;
	 
	 @Override
	 public String addProject(Project project) {
		 
		return projectDaoInterface.addProject(project);
	 }

	@Override
	public String addTask(Task task,String pId) {
		return projectDaoInterface.addTask(task, pId);
	}

	@Override
	public List<Project> getProjects(){
		return projectDaoInterface.getProjects();
	}

	@Override
	public List<Task> getTasks(String pId) {
		return projectDaoInterface.getTasks(pId);
	}

	@Override
	public String addStage(Stage stage, String pId, String tId) {
		return projectDaoInterface.addStage(stage,pId,tId);
		
	}

	@Override
	public List<Stage> getStages(String tId) {
		return projectDaoInterface.getStages(tId);
	}

	@Override
	public Project getAProject(String pId) {
		return projectDaoInterface.getAProject(pId);
	}


	 
}









//@Override
//public void sendProjectToKafka(Project project) {
//	 String topic = "project-topic";
//	 try {
//		 kafkaTemplate.send(topic, project);
//	 } catch (Exception e) {
//		 e.printStackTrace();
//	 }
//}