package com.student.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rollNo;

	@Column
	private String fName;

	@Column
	private String lName;

	@Column
	private String standard;

	@Column
	private String totalMarks;

	@Column
	private String universityName;

	public Student() {
	}

	public Student(Long rollNo, String fName, String lName, String standard, String totalMarks, String universityName) {
		super();
		this.rollNo = rollNo;
		this.fName = fName;
		this.lName = lName;
		this.standard = standard;
		this.totalMarks = totalMarks;
		this.universityName = universityName;
	}

	@Override
	public String toString() {
		return "Student(RollNo = " + rollNo + ", fName = " + fName + ", lName = " + lName + ", Standad = " + standard
				+ ", TotalMarks = " + totalMarks + ", Univesity = " + universityName;
	}

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
}
