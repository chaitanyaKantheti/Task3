package com.ownTask.Task3.models;

import java.io.Serializable;

public class Movie implements Serializable{
	int id;
	String name;
	
	private static final long serialVersionUID = 1L;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	 @Override
	 public String toString(){
	     return "Movie{" + "id=" +id + '\''  + ", name =" + name + "}";
	 }
	
}
