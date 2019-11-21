package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name  = "customer")

public class Customer 
{
	
	@Id
	@GeneratedValue(strategy= GenerationType .IDENTITY)
	private int cust_id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "email")
	private String email;
	public Customer(String Name, String type, String email) {
		super();
		this.name = Name;
		this.type = type;
		this.email = email;
	}
}
