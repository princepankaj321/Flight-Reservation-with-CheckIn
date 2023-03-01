package com.pankajcreation.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pankajcreation.flightreservation.entities.User;

public interface Userrepository extends JpaRepository<User, Long> {

	//@Query(value = "select * from user where emaill='?'", nativeQuery = true)
	User findByEmaill(String emaill);

}
