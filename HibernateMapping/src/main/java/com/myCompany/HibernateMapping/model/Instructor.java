package com.myCompany.HibernateMapping.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Instructor")

public class Instructor implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetails details;
	
	
	public Instructor() {
		
	}

	public Instructor(String firstName, String lastName, String email) {
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + first_name + ", lastName=" + last_name + ", email=" + email
				+ ", instructorDetail=" + details + "]";
	}
	
}












