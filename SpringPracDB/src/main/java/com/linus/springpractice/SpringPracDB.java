package com.linus.springpractice;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.linus.model.FoodGroup;
import com.linus.model.FoodGroupDAO;

public class SpringPracDB {
	
	public static void main(String... arg) {
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
		
		try {
			FoodGroupDAO fGroupDAO = appContext.getBean("foodGroupDAO", FoodGroupDAO.class);
			
//			List<FoodGroup> fGroupList1 = fGroupDAO.getFoodGroups();
//			if(fGroupList1 != null && fGroupList1.size()>0) {
//				for(FoodGroup fGroup : fGroupList1) {
//					System.out.println(fGroup.talkAboutYourself());
//				}
//			}
			
//			List<FoodGroup> fGroupList2 = fGroupDAO.getSpecificFoodGroupList("Fruit");
//			if(fGroupList2 != null && fGroupList2.size() >0) {
//				for(FoodGroup fGroup : fGroupList2) {
//					System.out.println(fGroup.talkAboutYourself());
//				}
//			}
			
//			FoodGroup fGroupById = fGroupDAO.getSpecificFoodGroupObject(3);
//			System.out.println(fGroupById.talkAboutYourself());

//			fGroupDAO.addFoodGroupToDB(6, "DummyFG", "Not a real food group");

			FoodGroup fGroupForDB = appContext.getBean("fGroupForDB",FoodGroup.class);
			fGroupDAO.addBeanToDB(fGroupForDB);			
		}
		catch(DataAccessException dae) {
			System.out.println("Exception occurred while accessing database");
			System.out.println(dae.getMessage());
			System.out.println(dae.getClass());
		}
		
		((FileSystemXmlApplicationContext)appContext).close();
	}    //main()

}
