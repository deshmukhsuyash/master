package com.aa.socialmedia.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class StudentEntity implements Serializable {

	private static final long serialVersionUID = 2271819315327649391L;
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

	@Column(name = "filedetails")
	private byte[] fileDetails;

}
