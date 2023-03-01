package com.booklibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.booklibrary.Dao.Bookrepository;
import com.booklibrary.entities.Bookdetails;

@RestController

public class Controllerforrest {
	@Autowired
	private Bookrepository bookrepository;

	@GetMapping("/bookhome")
	public List<Bookdetails> bookalldata() {
		List<Bookdetails> all = (List<Bookdetails>) this.bookrepository.findAll();
		return all;
	}

	// find by id
	@GetMapping("/bookhome/{bid}")
	public Optional<Bookdetails> find(@PathVariable("bid") int bid) {
		
		
		Optional<Bookdetails> findById = this.bookrepository.findById(bid);
		return findById;
	}

	// single data saving
	@PostMapping("/bookhome")
	public Bookdetails adding(@RequestBody Bookdetails bookdetails) {
		Bookdetails save = bookrepository.save(bookdetails);
		return save;
	}

	// delete record by id
	@DeleteMapping("/bookhome/{bid}")
	public void deletebook(@PathVariable("bid") int bid) {

		this.bookrepository.deleteById(bid);
		System.out.println("data deleted by id");

	}

	// update record by id

	@PutMapping("/bookhome/{bid}")
	public Bookdetails update(@RequestBody Bookdetails bookdetails, @PathVariable("bid") int bid) {
	
		Optional<Bookdetails> findById = this.bookrepository.findById(bid);

		Bookdetails save = bookrepository.save(bookdetails);
		return save;
	}

}