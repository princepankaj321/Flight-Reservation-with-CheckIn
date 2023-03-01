package com.librarymgm.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymgm.Dao.Bookrepo;
import com.librarymgm.Dao.Studentrepo;
import com.librarymgm.entities.Book;
import com.librarymgm.entities.Logicbuilding;


@Component
public class Libraryservices {

	@Autowired
	private Bookrepo bookrepo;
	@Autowired
	private Studentrepo studentrepo;
	
	//saving book

	public void addingbookservice(Book book, int qty)
	{
		
		
		
		for (int i = 0; i <qty; i++) {
			Book addingbook = new Book();

			addingbook.setBname(book.getBname());
			addingbook.setBprize(book.getBprize());
			addingbook.setStudentdetails(null);
			addingbook.setIssueornot(false);
			
			bookrepo.save(addingbook);
		}
		
	}
	
	public List<Book> allbookreturn()
	{
		List<Book> findAll = this.bookrepo.findAll();
		
		return findAll;
	}

	
}
