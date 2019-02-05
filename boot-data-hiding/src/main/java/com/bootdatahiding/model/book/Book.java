package com.bootdatahiding.model.book;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book_TB")
public class Book {
	public Book(int i, String string) {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private int id;
	private String name;
}
