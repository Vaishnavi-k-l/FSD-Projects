package com.myCompany.myHibernateProject.entity;

import java.io.Serializable;

import java.util.UUID;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "Student")

public class Student implements Serializable
{

	private static final long serialVersionUID = 5573467667702441271L;
	@Id
	@Column(name = "id")

	private int id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email")
	private String email;
    	

}
