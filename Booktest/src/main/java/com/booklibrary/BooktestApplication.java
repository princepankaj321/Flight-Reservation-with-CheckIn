package com.booklibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.booklibrary.Dao.Bookrepository;

@SpringBootApplication
public class BooktestApplication {

	public static void main(String[] args) {
	SpringApplication.run(BooktestApplication.class, args);
		
		//Bookrepository bookrepository = context.getBean(Bookrepository.class);
		
		
		
	}

}
