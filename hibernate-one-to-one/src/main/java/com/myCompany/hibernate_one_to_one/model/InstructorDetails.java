package com.myCompany.hibernate_one_to_one.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="instructor_detail")

public class InstructorDetails implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String hobby;
	private String youtube;
	
	@OneToOne(mappedBy = "details",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH})
	private Instructor instructor;
	
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
