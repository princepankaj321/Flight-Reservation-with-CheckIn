package com.librarymgm.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.librarymgm.entities.Studentdetails;


public interface Studentrepo extends CrudRepository<Studentdetails, Integer> {

	

	
}
