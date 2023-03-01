package com.springboot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.entities.Userinfo;



public interface UserRepository  extends CrudRepository<Userinfo, Integer>{

	// custom method creation 
	
	public List<Userinfo> findByUcity(String ucity);
	
	
	// hibernate custom query
	
	@Query("select a from Userinfo a")
	public List<Userinfo> getAllUserinfos();
	

	// 2nd hibernate query with where condition
	
	@Query("select a from Userinfo a where a.uname=:b and a.ucity=:c")
	public List<Userinfo> getUserinfoByUname(@Param("b") String uname, @Param ("c") String ucity );
	
	
	// normal sql query
	@Query(value= "select * from userinfo", nativeQuery = true )
	public List<Userinfo> getallusers();
	
	
	
}
