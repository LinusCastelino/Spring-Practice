package com.linus.model;

public class FoodGroup {

	private int id;
	private String name;
	private String description;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String talkAboutYourself() {
		
		String message="\nFood Group:\nID - "+getId()+"\nName - "+getName()
						+"\nDescription - "+getDescription();
						
		return message;
	}
	
}
