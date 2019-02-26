package com.ownTask.Task3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ownTask.Task3.models.Project;
import com.ownTask.Task3.models.Stage;
import com.ownTask.Task3.models.Task;

@Component
public class ProjectDaoImpl implements ProjectDAOInterface{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public String addProject(Project project){
		
		Connection connection=null;
		PreparedStatement pro=null;
		PreparedStatement tsk=null;
		PreparedStatement stg=null;
		
		try {
			connection=this.dataSource.getConnection();
			Iterator<Task> itr_Task=project.getTasks().iterator();
			pro=connection.prepareStatement("insert into project(p_id,p_name)values('"+project.getpId()+"','"+project.getpName()+"')");
			pro.execute();
			while(itr_Task.hasNext()) {
				Task task=itr_Task.next();
				Iterator<Stage> itr_Stage=task.getStages().iterator();
				tsk=connection.prepareStatement("insert into task(t_id,t_name,p_id)values('"+task.gettId()+"','"+task.gettName()+"','"+project.getpId()+"')");
				tsk.execute();
				while(itr_Stage.hasNext()) {
					Stage stage=itr_Stage.next();
					stg=connection.prepareStatement("insert into stage(s_id,s_name,t_id) values('"+stage.getsId()+"','"+stage.getsName()+"','"+task.gettId()+"')");
					stg.execute();
				}
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return "successfully inserted into database";
		
	}

	@Override
	public String addTask(Task task,String pId) {
		Connection connection=null;
		PreparedStatement ps=null;
		
		try {
			connection=this.dataSource.getConnection();
			ps=connection.prepareStatement("insert into task(t_id,t_name,p_id)values('"+task.gettId()+"','"+task.gettName()+"','"+pId+"')");
			ps.execute();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return "added a task successfullys";
	}

	@Override
	public List<Project> getProjects() {
		Connection connection=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		
		List<Project> projects=new ArrayList<>();
		
		try {
			connection=this.dataSource.getConnection();
			ps=connection.prepareStatement("SELECT p_id,p_name from project");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Project project=new Project();
				String pId=rs.getString("p_id");
				ps1=connection.prepareStatement("select t_id,t_name from task where p_id='"+pId+"'");
				rs1=ps1.executeQuery();
				List<Task> tasks=new ArrayList<>();
				while(rs1.next()) {
					Task task=new Task();
					String tId=rs1.getString("t_id");
					ps2=connection.prepareStatement("SELECT s_id,s_name from stage where t_id='"+tId+"'");
					rs2=ps2.executeQuery();
					List<Stage> stages=new ArrayList<>();
					while(rs2.next()) {
						Stage stage=new Stage();
						stage.setsId(rs2.getString("s_id"));
						stage.setsName(rs2.getString("s_name"));
						stages.add(stage);
					}
					task.settId(rs1.getString("t_id"));
					task.settName(rs1.getString("t_name"));
					task.setStages(stages);
					tasks.add(task);
				}
				project.setpId(rs.getString("p_id"));
				project.setpName(rs.getString("p_name"));
				project.setTasks(tasks);
				projects.add(project);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return projects;
	}


	@Override
	public String addStage(Stage stage, String pId, String tId) {
		Connection connection=null;
		PreparedStatement ps=null;
		
		try {
			connection=this.dataSource.getConnection();
			ps=connection.prepareStatement("insert into stage(s_id,s_name,t_id)values('"+stage.getsId()+"','"+stage.getsName()+"','"+tId+"')");
			ps.execute();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return "Added a stage successully";
	}

	@Override
	public List<Stage> getStages(String tId) {
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Stage> stg=new ArrayList<>();
		
		try {
			connection=this.dataSource.getConnection();
			ps=connection.prepareStatement("SELECT stage.s_id,stage.s_name FROM (task INNER JOIN stage ON task.t_id=stage.t_id) WHERE task.t_id='"+tId+"'");
			rs=ps.executeQuery();
			while(rs.next()) {
				Stage stages=new Stage();
				stages.setsId(rs.getString("s_id"));
				stages.setsName(rs.getString("s_name"));
				stg.add(stages);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return stg;
	}

	@Override
	public Project getAProject(String pId) {
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PreparedStatement ps1=null;
		ResultSet rs1=null;
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		
		
		Project project=new Project();
		
		try {
			connection=this.dataSource.getConnection();
			ps=connection.prepareStatement("select t_id,t_name from task where p_id='"+pId+"'");
			rs=ps.executeQuery();
			List<Task> tasks=new ArrayList<>();
			while(rs.next()) {
				Task task=new Task();
				String tId=rs.getString("t_id");
				try {
					ps1=connection.prepareStatement("select s_id,s_name from stage where t_id='"+tId+"'");
					rs1=ps1.executeQuery();
					List<Stage> stages=new ArrayList<>();
					while(rs1.next()) {
						Stage stage=new Stage();
						stage.setsId(rs1.getString("s_id"));
						stage.setsName(rs1.getString("s_name"));
						stages.add(stage);
					}
					task.settId(rs.getString("t_id"));
					task.settName(rs.getString("t_name"));
					task.setStages(stages);
					tasks.add(task);
					try {
						ps2=connection.prepareStatement("SELECT p_name from project where p_id='"+pId+"'");
						rs2=ps2.executeQuery();
						while(rs2.next()) {
							project.setpId(pId);
							project.setpName(rs2.getString("p_name"));
							project.setTasks(tasks);
						}
					}catch(SQLException e) {
						System.out.println("Exception occured while fetching data from project "+e);
					}
				}catch(SQLException e) {
					System.out.println("Exception while fetching data from Stage table "+e);
				}	
			}	
		}catch(SQLException e) {
			System.out.println("Exception while fetching data from Task table "+e);
		}
		return project;
	}

	

	@Override
	public List<Task> getTasks(String pId){
		Connection connection=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		
		ResultSet rs=null;
		ResultSet rs1=null;
		
		List<Task> tasks=new ArrayList<>();
		
		
		try { 
			connection=this.dataSource.getConnection();
			ps=connection.prepareStatement("select t_id,t_name from task where p_id='"+pId+"'");
			rs=ps.executeQuery();
			while(rs.next()) {
				Task task=new Task();
				String tId=rs.getString("t_id");
				try {
					ps1=connection.prepareStatement("select s_id,s_name from stage where t_id='"+tId+"'");
					rs1=ps1.executeQuery();
					List<Stage> stages=new ArrayList<>();
					while(rs1.next()) {
						Stage stage=new Stage();
						stage.setsId(rs1.getString("s_id"));
						stage.setsName(rs1.getString("s_name"));
						stages.add(stage);
					}
					task.settId(rs.getString("t_id"));
					task.settName(rs.getString("t_name"));
					task.setStages(stages);
					tasks.add(task);
				}catch(SQLException e) {
					System.out.println("Exception while fetching data from Stage table"+e);
				}	
			}	
		}catch(SQLException e) {
			System.out.println("Exception while fetching data from Task table"+e);
		}	
		return tasks;
	}

}
