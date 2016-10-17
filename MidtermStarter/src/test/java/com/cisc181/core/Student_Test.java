package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

import com.cisc181.exceptions.*;


public class Student_Test {
	
	private static ArrayList<Course> Courses = new ArrayList<Course>();
	private static ArrayList<Semester> Semesters = new ArrayList<Semester>();
	private static ArrayList<Section> Sections = new ArrayList<Section>();
	private static ArrayList<Student> Students = new ArrayList<Student>();
	private static ArrayList<Enrollment> Enrollments = new ArrayList<Enrollment>();
	@BeforeClass
	public static void setup() throws PersonException {
		Course Biology = new Course();
		Biology.setCourseID(UUID.randomUUID());
		Biology.setCourseName("Biology");
		Biology.setGradePoints(4);
		Biology.seteMajor(eMajor.NURSING);
		
		Course Economics  = new Course();
		Economics.setCourseID(UUID.randomUUID());
		Economics.setCourseName("Economics");
		Economics.setGradePoints(4);
		Economics.seteMajor(eMajor.BUSINESS);
		
		Course Calculus = new Course();
		Calculus.setCourseID(UUID.randomUUID());
		Calculus.setCourseName("Calculus");
		Calculus.setGradePoints(4);
		Calculus.seteMajor(eMajor.PHYSICS);
		
		Courses.add(Biology);
		Courses.add(Economics);
		Courses.add(Calculus);
		
		Semester Fall = new Semester();
		Fall.setSemesterID(UUID.randomUUID());
		Calendar classTime = Calendar.getInstance();
		classTime.set(2016, Calendar.AUGUST,30);
		Fall.setStartDate(classTime.getTime());
		classTime.set(2016, Calendar.DECEMBER,17);
		Fall.setEndDate(classTime.getTime());
		
		Semester Spring = new Semester();
		Spring.setSemesterID(UUID.randomUUID());
		Calendar classTime = Calendar.getInstance();
		classTime.set(2017, Calendar.FEBRUARY,6);
		Spring.setStartDate(classTime.getTime());
		classTime.set(2017, Calendar.MAY,25);
		Spring.setEndDate(classTime.getTime());
		
		Section NFall = new Section(Biology.getCourseID(),Fall.getSemesterID());
		Section NSpring = new Section(Biology.getCourseID(),Spring.getSemester());
		Section NFall = new Section(Economics.getCourseID(),Fall.getSemesterID());
		Section NSpring = new Section(Economics.getCourseID(),Spring.getSemester());
		Section NFall = new Section(Calculus.getCourseID(),Fall.getSemesterID());
		Section NSpring = new Section(Calculus.getCourseID(),Spring.getSemester());
		
		Sections.add(ESpring);
		Sections.add(EFall);
		Sections.add(SFall);
		Sections.add(SSpring);
		Sections.add(NFall);
		Sections.add(NSpring);
		
		Student Alex = new Student("Alex", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student Dahna = new Student("Dahna", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student Matt = new Student("Matt", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student George = new Student("George", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student Katherine = new Student("Katherine", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student Kevin = new Student("Kevin", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student Mark = new Student("Mark", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student Sam = new Student("Sam", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student Ken = new Student("Ken", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		Student Rachel = new Student("Rachel", new Date(), eMajor.NURSING, "1 Spruce Street", "(012)-345-6789", "blim@udel.edu");
		
		Students.add(Alex);
		Students.add(Dahna);
		Students.add(Matt);
		Students.add(George);
		Students.add(Katherine);
		Students.add(Kevin);
		Students.add(Mark);
		Students.add(Sam);
		Students.add(Ken);
		Students.add(Rachel);
		
		
		for(Student s : Students) {
			for(Section s2 : Sections) {
				Enrollments.add(new Enrollment(s2.getCourseID(),s.getStudentID()));
			}
		}
		
		for(Enrollment e : Enrollments) {
			e.setGrade(90);
		}
		
	}
	
	public double CalculateGPA(double grade) {
		double GPA = 0;
		for(Enrollment e : Enrollments) {
			if ((grade >= 90) && (grade <= 100)) {
				GPA = 4.0;
			}
			else if ((grade >= 80) && (grade <= 89)) {
				GPA = 3.0;
			}
			else if ((grade >= 70) && (grade <= 79)) {
				GPA = 2.0;
			}
			else if ((grade >= 60) && (grade <= 69)) {
				GPA = 1.0;
			}
			else 
				GPA = 0.0;
		}
	}
	return GPA
}

public double TotalGPA(Student s) {
	double totalGPA = 0;
	double finalGPA = 0;
	int classcount = 0;
	for (Enrollment e : Enrollments)
		if (e.getStudentID() == s.getStudentID()) {
			totalGPA += (CalculateGPA(e.getGrade()));
			classcount++;
		}
	finalGPA = totalGPA/classcount;
	return finalGPA;
}

	@Test
	public void GPATest() {
		assertEquals(4, TotalGPA(Students.get(0)),0);
	}
	
	@Test
	public void CourseAverageTest() {
		double totalGrades = 0;
		double CourseAverage = 0;
		for (Enrollment e : Enrollments) {
			totalGrades += e.getGrade();
		}
		
		CourseAverage = totalGrades/Enrollments.size();
		
		assertEquals(90,CourseAverage,0);
}
	@Test
	public void MajorChangeTest() {
		Students.get(0).setMajor(eMajor.NURSING);
		assertEquals(eMajor.NURSING,Students.get(0).getMajor());
	}