package com.ownTask.Task3.models;


import java.util.List;


public class Task {

	String tId;
	String tName;
	

	private List<Stage> stages;
	
	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	
}
