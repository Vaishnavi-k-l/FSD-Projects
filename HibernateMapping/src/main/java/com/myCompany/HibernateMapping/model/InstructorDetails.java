package com.myCompany.HibernateMapping.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "InstructorDetails")
public class InstructorDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	private String youtube;
	private String hobby;
	
	public InstructorDetails() {
		
	}

	public InstructorDetails(String youtubeChannel, String hobby) {
		this.youtube = youtubeChannel;
		this.hobby = hobby;
	}

	

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtube + ", hobby=" + hobby + "]";
	}
	
}
