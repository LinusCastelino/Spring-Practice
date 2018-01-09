package com.linus.food;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Meal implements InitializingBean,DisposableBean{
	
	List<Fruit> fruits;
	Vegetable vegetable;
	Grain grain;
	Dairy dairy;
	Meat meat;
	
	public List<Fruit> getFruits(){
		return fruits;
	}
	
	public void setFruits(List<Fruit> frts) {
		fruits=frts;
	}
	
	public Vegetable getVegetable() {
		return vegetable;
	}

	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}

	public Grain getGrain() {
		return grain;
	}

	public void setGrain(Grain grain) {
		this.grain = grain;
	}

	public Dairy getDairy() {
		return dairy;
	}

	public void setDairy(Dairy dairy) {
		this.dairy = dairy;
	}

	public Meat getMeat() {
		return meat;
	}

	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	Meal(){
		System.out.println("\n****** Meal : In default Constructor ******");
	}

	Meal(List<Fruit> frts, Vegetable veg, Grain grn, Dairy dry, Meat mt){
		System.out.println("\n****** Meal : In parameterized Constructor ******");
		fruits=frts;
		vegetable=veg;
		grain=grn;
		dairy=dry;
		meat=mt;
	}
	
	public void customInitMethod() {
		System.out.println("~~~~~~ Inside Custom Init Method  ~~~~~~");
	}
	
	public void customDestroyMethod() {
		System.out.println("~~~~~~ Inside Custom Destroy Method  ~~~~~~");
	}
	
	public void afterPropertiesSet() {
		System.out.println("###### Inside InitializingBean's afterPropertiesSet Method  ######");
	}
	
	public void destroy() {
		System.out.println("\n###### Inside DisposableBean's destroy Method  ######");
	}
	
	@PostConstruct    //need to include common-annotations.jar and register the bean
	public void printAfterBeanConstructed() {
		System.out.println("^^^^^^ Inside @PostConstruct  ^^^^^^");
	}
	
	@PreDestroy    //need to include common-annotations.jar and register the bean
	public void printBeforeBeanDestroyed() {
		System.out.println("\n^^^^^^ Inside @PreDestroy  ^^^^^^");
	}
	
	public void whatsInTheMeal() {
		System.out.println("Today's meal contains :");
		int i=1;
		
		if(fruits!=null && fruits.size()>0) {
			for(Fruit fruit : fruits ) {
				System.out.println(i+++". "+fruit.talkAboutYouself());
			}
		}
		
		if(getVegetable() != null && !getVegetable().equals(""))
			System.out.println(i+++". "+getVegetable().talkAboutYourself());
		
		if(getDairy() != null && !getDairy().equals(""))
			System.out.println(i+++". "+getDairy().talkAboutYourself());
		
		if(getGrain() != null && !getGrain().equals(""))
			System.out.println(i+++". "+getGrain().talkAboutYourself());
		
		if(getMeat() != null && !getMeat().equals(""))
			System.out.println(i+++". "+getMeat().talkAboutYourself());
		
		if(i==1)
			System.out.println("Nothing");
	}

}