package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment() {
		
	}
	public Enrollment(UUID SectionId, UUID StudentID) {
		this.EnrollmentID = UUID.randomUUID();
		this.StudentID = StudentID;
		this.SectionID = SectionID;
	}
	
	public UUID getSectionID() {
		return SectionID;
	}
	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}
	public UUID getStudentID() {
		return StudentID;
	}
	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentId(UUID enrollmentId) {
		EnrollmentID = enrollmentId;
	}
	public double getGrade() {
		return Grade;
	}
	public void setGrade(double grade) {
		this.Grade = grade;
	}

}
