package com.pankajcreation.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankajcreation.flightreservation.entities.Role;

public interface Rolerepository extends JpaRepository<Role, Integer> {

}
