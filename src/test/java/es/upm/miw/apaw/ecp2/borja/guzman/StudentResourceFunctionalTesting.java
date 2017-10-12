package es.upm.miw.apaw.ecp2.borja.guzman;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpException;


public class StudentResourceFunctionalTesting {

	@Before
	public void before() {

	}

	private void createStudent() {
		
	}

	@Test
	public void testCreateStudent() {

		this.createStudent();
	}
	
	@Test(expected= HttpException.class)
	public void testCreateStudentNameEmpty() {
		throw new HttpException("test");
	}
	
	@Test(expected= HttpException.class)
	public void testCreateStudentDNIEmpty() {
		throw new HttpException("test");
	}
	
	@Test(expected= HttpException.class)
	public void testCreateStudentBirthDateEmpty() {
		throw new HttpException("test");
	}
	
	@Test(expected= HttpException.class)
	public void testCreateStudentRepeated() {
		this.createStudent();
		this.createStudent();
		throw new HttpException("test");
	}
}
