package com.springboot.jpa;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.jpa.dao.UserRepository;
import com.springboot.jpa.entities.Userinfo;

import antlr.collections.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(JpaApplication.class, args);
	
	UserRepository repository =  context.getBean(UserRepository.class);
	/*
	//save single
	Userinfo info = new Userinfo();
	info.setUname("soujanya");
	info.setUcity("hyderabad");
	info.setUnum(989898989);
	Userinfo save = repository.save(info);
	Userinfo info2 = new Userinfo("pooja", "pune", 9889895);
	Userinfo save2 = repository.save(info2);
	System.out.println(save);
	System.out.println(save2);
	
	//save all object
	
	Userinfo info3 = new Userinfo("karthik", "mumbai", 9889899);
	Userinfo info4 = new Userinfo("aaryan", "supara", 9889410);
	Userinfo info5 = new Userinfo("shahrukh", "mannat", 4789895);
	Userinfo info6 = new Userinfo("salman", "delhi", 988874095);
	ArrayList l =  new ArrayList<Userinfo>();
	l.add(info3);
	l.add(info4);
	l.add(info5);
	l.add(info6);
	Iterable all = repository.saveAll(l);
	System.out.println(all);
	*/
	
	//get single user details by id
	//and update the existing value from database
	/*
	Optional<Userinfo> id = repository.findById(7);
	
	Userinfo userinfo = id.get();
	
	userinfo.setUname("ravina");
	userinfo.setUcity("jalna");
	Userinfo result = repository.save(userinfo);
	System.out.println(result);
	*/
	
	/*
	//get all data from database
	Iterable<Userinfo> all = repository.findAll();
	// using for each loop
//	for (Userinfo userinfo : all) {
//		
//		System.out.println(userinfo);
//	}
	// using lamda function
	all.forEach(user->{System.out.println(user);});
	
	*/

		// pending
		//Iterable<Userinfo> findAllById = repository.findAllById(i);
		//System.out.println(findAllById);

		
		// deleting
		// repository.deleteById(12);
	
	
	/*
	// custom method creation
	java.util.List<Userinfo> ucity = repository.findByUcity("hyderabad");
	
	for (Userinfo userinfo : ucity) {
		
		System.out.println(userinfo);
	}
	
	*/
	
	
	/*
	// this is for hibernate query
	java.util.List<Userinfo> all = repository.getAllUserinfos();
	
	for (Userinfo userinfo : all) {
		
		System.out.println(userinfo);
	}
	*/
	
	
	/*
	
	// this is for hibernate query with where condtion
	java.util.List<Userinfo> byname = repository.getUserinfoByUname("soujanya", "hyderabad");
	
	for (Userinfo userinfo2 : byname) {
		
		System.out.println(userinfo2);
	}
	

	*/
	
	
	// this is for normal sql query
	
	java.util.List<Userinfo> normalsqlalluserinfo = repository.getAllUserinfos();
	
	for (Userinfo userinfo : normalsqlalluserinfo) {
		
		System.out.println(userinfo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
