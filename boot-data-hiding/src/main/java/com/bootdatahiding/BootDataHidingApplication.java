package com.bootdatahiding;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootdatahiding.book.repository.BookRepo;
import com.bootdatahiding.model.book.Book;
import com.bootdatahiding.model.user.User;
import com.bootdatahiding.user.repository.UserRepo;

@SpringBootApplication
@RestController

public class BootDataHidingApplication {
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@PostConstruct
	public void addData2Db() {
		userRepo.saveAll(Stream.of(new User(755, "John"), new User(756, "Peter")).collect(Collectors.toList()));
		bookRepo.saveAll(Stream.of(new Book(111, "corejava"), new Book(222 , "java")).collect(Collectors.toList()));
	}
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks(){
		return bookRepo.findAll();
	}
	public static void main(String[] args) {
		SpringApplication.run(BootDataHidingApplication.class, args);
	}

}

