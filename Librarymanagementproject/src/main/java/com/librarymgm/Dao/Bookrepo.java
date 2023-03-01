package com.librarymgm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.librarymgm.entities.Book;


public interface Bookrepo extends JpaRepository<Book, Integer> {

	

	
}
