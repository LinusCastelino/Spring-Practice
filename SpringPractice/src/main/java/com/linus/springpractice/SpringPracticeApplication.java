package com.linus.springpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.linus.events.SampleEventPublisher;
import com.linus.food.Fruit;
import com.linus.food.Meal;

public class SpringPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		SampleEventPublisher eventPublisher = appContext.getBean(SampleEventPublisher.class);
		eventPublisher.publishEvent("Application Initialized");
		
		//System.out.println("\n:: Fruit ::");
		//Fruit myFruit= appContext.getBean("fruit1",Fruit.class);
		//System.out.println(myFruit.talkAboutYouself());
		
		//System.out.println("\n:: Fruit List ::");
		//Fruit myFruitList= appContext.getBean("fruitList",Fruit.class);
		//myFruitList.printListOfFruits();
		
		//System.out.println("\n:: Meal ::");
		//Meal myMeal = appContext.getBean("meal", Meal.class);
		//myMeal.whatsInTheMeal();
		
		//System.out.println("\n:: Meal Initialized Using Constructor Parameter Index ::");
		//Meal myMealUsingIndex = appContext.getBean("mealUsingIndex", Meal.class);
		//myMealUsingIndex.whatsInTheMeal();
		
		//System.out.println("\n:: Meal Initialized Using Constructor Parameter Name ::");
		//Meal myMealUsingName= (Meal)appContext.getBean("mealUsingName");
		//myMealUsingName.whatsInTheMeal();
		
		//System.out.println("\n:: Meal Autowired - By Name ::");
		//Meal myMealAutowiredByName = appContext.getBean("mealAutowiredByName",Meal.class);
		
		//System.out.println("\n:: Meal Autowired - By Type ::");
		//Meal myMealAutowiredByType = appContext.getBean("mealAutowiredByType",Meal.class);
		//myMealAutowiredByType.whatsInTheMeal();
		
		System.out.println("\n:: Meal Autowired - By Contructor ::");
		Meal myMealConstructorAutowired = appContext.getBean("mealConstructorAutowired", Meal.class);
		myMealConstructorAutowired.whatsInTheMeal();
		eventPublisher.publishEvent();
		
		eventPublisher.publishEvent("Closing application context");
		((ClassPathXmlApplicationContext)appContext).close();
		
	}
}
