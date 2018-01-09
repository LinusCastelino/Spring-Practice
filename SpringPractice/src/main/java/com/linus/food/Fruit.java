package com.linus.food;

import java.util.List;

public class Fruit {
	
	private String fruitName;
	private List<String> listOfFruits;
	
	public void setFruitName(String fruitName) {
		this.fruitName= fruitName;
	}
	
	public String getFruitName() {
		return fruitName;
	}
	
	public void setListOfFruits(List<String> listOfFruits) {
		this.listOfFruits=listOfFruits;
	}
	
	public List<String> getListOfFruits(){
		return listOfFruits;
	}
	
	public String talkAboutYouself() {
		String message = "I am a fruit.";
		if(getFruitName() != null && !fruitName.equals("")) {
			message = "I am "+getFruitName()+". "+message;			
		}
		return message;
	}
	
	public void printListOfFruits() {
		if(getListOfFruits() != null && getListOfFruits().size()>0) {
			for(String fruit: getListOfFruits()) {
				System.out.println(fruit);
			}
		}
		else {
			System.out.println("No fruits added to the list");
		}
	}

}
