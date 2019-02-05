package com.bootdatahiding.model.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_DB")
public class User {
	
	public User(int i, String string) {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String Username;
	
	
}
