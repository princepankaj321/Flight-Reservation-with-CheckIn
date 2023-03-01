package com.librarymgm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarymgm.Dao.Bookrepo;
import com.librarymgm.Dao.Studentrepo;
import com.librarymgm.entities.Book;
import com.librarymgm.services.Libraryservices;

@Controller
public class Librarycontroller {

	@Autowired
	private Libraryservices libraryservices;

	@RequestMapping(path = "/savebook", method = RequestMethod.POST )
	public String adding(@RequestBody Book book, @RequestParam("qty") int qty)
	{
		libraryservices.addingbookservice(book, qty);
		
		return "savebook";
	}
	@GetMapping("/bookall")
	public List <Book> allbook()
	{
		List<Book> allbookreturn = libraryservices.allbookreturn();
		return allbookreturn;
	}
	
	
	
	
}
