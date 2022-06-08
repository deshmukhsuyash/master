package com.aa.socialmedia.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class StudentEntity implements Serializable {

	private static final long serialVersionUID = -4290707108630432394L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentBranch;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@BatchSize(size = 30)
	private List<BookEntity> book = new ArrayList<>();

}
