package es.upm.miw.apaw.ecp2.borja.guzman;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.StudentResource;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.SubjectResource;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpClientService;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpException;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpMethod;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpRequest;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpRequestBuilder;

public class StudentResourceFunctionalTesting {

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
	}

	private void createStudent() {
		createSubject();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(StudentResource.STUDENT)
				.body("student1:00000000x:01/01/1994:1").build();
		new HttpClientService().httpRequest(request);
	}

	private void createSubject() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SubjectResource.SUBJECT)
				.body("Matemáticas:1").build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testCreateStudent() {

		this.createStudent();
	}

	@Test(expected = HttpException.class)
	public void testCreateStudentNameEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(StudentResource.STUDENT)
				.body(":00000000x:01/01/1994:1").build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateStudentDNIEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(StudentResource.STUDENT)
				.body("student1::01/01/1994:1").build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateStudentBirthDateEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(StudentResource.STUDENT)
				.body("student1:00000000x::1").build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateStudentRepeated() {
		this.createStudent();
		this.createStudent();
		throw new HttpException("test");
	}

	@Test(expected = HttpException.class)
	public void testCreateStudentIdSubjectNotFound() {
		createSubject();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(StudentResource.STUDENT)
				.body("student1:00000000x:01/01/1994:2").build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testReadStudent() {
		createStudent();
	}

	@Test(expected = HttpException.class)
	public void testReadStudentWithIdEmpty() {
		throw new HttpException("");
	}

	@Test(expected = HttpException.class)
	public void testReadStudentIdNotFound() {
		throw new HttpException("");
	}

}
