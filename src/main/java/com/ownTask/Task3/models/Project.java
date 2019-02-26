package com.ownTask.Task3.models;

import java.util.List;

public class Project {
	
		String pId;
		String pName;
		
	
		private List<Task> tasks;
		
		
		public String getpId() {
			return pId;
		}
		public void setpId(String pId) {
			this.pId = pId;
		}
		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
	
		
		public List<Task> getTasks() {
			return tasks;
		}
		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}
		
		public Project(String pId, String pName, List<Task> tasks) {
			super();
			this.pId = pId;
			this.pName = pName;
			this.tasks = tasks;
		}
		public Project() {
			super();
			
		}
}
