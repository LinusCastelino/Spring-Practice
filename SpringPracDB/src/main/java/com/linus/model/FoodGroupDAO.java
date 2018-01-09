package com.linus.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

@Repository("foodGroupDAO")
public class FoodGroupDAO {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public NamedParameterJdbcTemplate getNamedParamJdbcTemplate() {
		return namedParamJdbcTemplate;
	}

	@Autowired
	public void setNamedParamJdbcTemplate(DataSource ds) {
		this.namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public List<FoodGroup> getFoodGroups(){
		String query="Select * from foodGroups";
		return getJdbcTemplate().query(query, new RowMapper<FoodGroup>(){

			@Override
			public FoodGroup mapRow(ResultSet arg0, int arg1) throws SQLException {
				FoodGroup fgroup = new FoodGroup();
				
				fgroup.setId(arg0.getInt("id"));
				fgroup.setName(arg0.getString("name"));
				fgroup.setDescription(arg0.getString("description"));
				
				return fgroup;
			}
			
		});
	}    //getFoodGroups()
	
	public List<FoodGroup> getSpecificFoodGroupList(String groupNameValue){
		
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("groupName", groupNameValue);
		
		String query="Select * from foodGroups where name= :groupName";
		
		return getNamedParamJdbcTemplate().query(query,sqlParams, new RowMapper<FoodGroup>() {

			@Override
			public FoodGroup mapRow(ResultSet arg0, int arg1) throws SQLException {
				FoodGroup fgroup = new FoodGroup();
				
				fgroup.setId(arg0.getInt("id"));
				fgroup.setName(arg0.getString("name"));
				fgroup.setDescription(arg0.getString("description"));
				
				return fgroup;
			}
			
		});
		
	}    //getSpecificFoodGroupList()
	
	public FoodGroup getSpecificFoodGroupObject(int id) {
		
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("id", id);
		
		String query="Select * from foodGroups where id= :id";
		
		return getNamedParamJdbcTemplate().queryForObject(query, sqlParams, new RowMapper<FoodGroup>() {

			@Override
			public FoodGroup mapRow(ResultSet arg0, int arg1) throws SQLException {
				FoodGroup fgroup = new FoodGroup();
				
				fgroup.setId(arg0.getInt("id"));
				fgroup.setName(arg0.getString("name"));
				fgroup.setDescription(arg0.getString("description"));
				
				return fgroup;
			}
			
		});
	}

	public void addFoodGroupToDB(int id, String name, String desc) {
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("id",id);
		sqlParams.addValue("name", name);
		sqlParams.addValue("desc", desc);
		
		String query= "insert into foodGroups (id,name,description) values"
				+ "(:id,:name,:desc)";
		
		int numOfRowsAffected = getNamedParamJdbcTemplate().update(query, sqlParams);
		
		if(numOfRowsAffected>0)
			System.out.println(numOfRowsAffected+" row(s) inserted.");
		else
			System.out.println("There was an error while inserting the row");
		
	}    //addFoodGroupToDB()

	public void addBeanToDB(FoodGroup fg) {
		
		BeanPropertySqlParameterSource beanSqlParamSrc = new BeanPropertySqlParameterSource(fg);
		
		String query= "insert into foodGroups (id,name,description) values"
				+ "(:id,:name,:description)";
		
		int numOfRowsAffected = getNamedParamJdbcTemplate().update(query, beanSqlParamSrc);
		
		if(numOfRowsAffected>0)
			System.out.println(numOfRowsAffected+" row(s) inserted.");
		else
			System.out.println("There was an error while inserting the row");
		
	}   //addBeanToDB()
	
	public void updateFoodGroup(int id, String name, String desc) {
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("id",id);
		sqlParams.addValue("name", name);
		sqlParams.addValue("desc", desc);
		
		String query="update foodgroups set name=:name, description=:desc where id=:id";
		
		int numOfRowsAffected = getNamedParamJdbcTemplate().update(query, sqlParams);
		
		if(numOfRowsAffected>0)
			System.out.println(numOfRowsAffected+" row(s) updated.");
		else
			System.out.println("There was an error while updating the row(s)");
	}

	public void deleteFroodGroup(int id) {
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("id",id);
		
		String query="delete from foodGroups where id=:id";
		
		int numOfRowsAffected = getNamedParamJdbcTemplate().update(query, sqlParams);
		
		if(numOfRowsAffected>0)
			System.out.println(numOfRowsAffected+" row(s) deleted.");
		else
			System.out.println("There was an error while deleting the row");
	}

	@Transactional("myTransactionManager")
	public int[] addFoodGroupsBatch(List<FoodGroup> fGroupList) {
		SqlParameterSource sqlParams[] = SqlParameterSourceUtils.createBatch(fGroupList.toArray());
		
		String query="update foodgroups set name=:name, description=:desc where id=:id";
		
		int[] numOfRowsAffected= getNamedParamJdbcTemplate().batchUpdate(query, sqlParams);
		
		return numOfRowsAffected;
	}    //addFoodGroupsBatch()
	
	
}    //class
