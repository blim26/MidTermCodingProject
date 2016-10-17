package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.exceptions.*;

public class Staff_Test {

	@BeforeClass
	public static void setup() throws PersonException {
	}
	
	@Test
	public void test() {
		Staff Brandon = new Staff(com.cisc181.eNums.eTitle.MR);
		Staff Dan = new Staff(com.cisc181.eNums.eTitle.MR);
		Staff Anne = new Staff(com.cisc181.eNums.eTitle.MS);
		Staff Andrew = new Staff(com.cisc181.eNums.eTitle.MR);
		Staff Alyssa = new Staff(com.cisc181.eNums.eTitle.MS);
		
		Brandon.setSalary(300);
		Dan.setSalary(500);
		Anne.setSalary(200);
		Andrew.setSalary(300);
		Alyssa.setSalary(300);
		
		ArrayList<Staff> SalaryTest = new ArrayList<Staff>();
		SalaryTest.add(Brandon);
		SalaryTest.add(Dan);
		SalaryTest.add(Anne);
		SalaryTest.add(Andrew);
		SalaryTest.add(Alyssa);
		
		
		double ExpectedAverage = ((300+500+200+300+300)/5);
		double CalculatedAverage = 0;
		for(int i = 0; i < SalaryTest.size();i++) {
			CalculatedAverage += SalaryTest.get(i).getSalary();
		}
		CalculatedAverage = CalculatedAverage / SalaryTest.size();
		
		assertEquals(ExpectedAverage,CalculatedAverage,0);
	}	
	
	@Test(expected = PersonException.class)
	public void testPersonExceptionPhone() throws PersonException{
		Staff Cliff = new Staff(com.cisc181.eNums.eTitle.MR);
		Cliff.setPhone("1(201)1234567");
	}
	
	@Test(expected = PersonException.class)
	public void testPersonExceptionDOB() throws PersonException {
		Staff Kim = new Staff(com.cisc181.eNums.eTitle.MS);
		Calendar age = Calendar.getInstance();
		age.set(1985, Calendar.JANUARY,29);
		Kim.setDOB(age.getTime());
	}
	

}
