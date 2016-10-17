package com.cisc181.core;

import java.util.UUID;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private com.cisc181.eNums.eMajor eMajor;
	
	public UUID getCourseID() {
		return CourseID;
	}
	
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	public int getGradePoints() {
		return GradePoints;
	}
	
	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}
	
	public com.cisc181.eNums.eMajor geteMajor() {
		return eMajor;
	}
	
	public void seteMajor(com.cisc181.eNums.eMajor eMajor) {
		this.eMajor = eMajor;
	}

}
