package com.aa.socialmedia.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class StudentEntity implements Serializable {

	private static final long serialVersionUID = 1668503404461287087L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private int studentId;
	@Column(name = "studentName")
	private String studentName;
	@Column(name = "studentEmail")
	private String studentEmail;
	@Column(name = "studentBranch")
	private String studentBranch;

	@Lob
	@Column(name = "fileDetails")
	private byte[] fileDetails;

}
