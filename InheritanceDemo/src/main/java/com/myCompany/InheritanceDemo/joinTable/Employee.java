package com.myCompany.InheritanceDemo.joinTable;


import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.Inheritance;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Employee_Directory")
public class Employee 
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	Employee()
	{
		
	}
	
}
