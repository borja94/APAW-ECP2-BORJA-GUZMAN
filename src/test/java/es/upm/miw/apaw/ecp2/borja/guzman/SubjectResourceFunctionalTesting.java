package es.upm.miw.apaw.ecp2.borja.guzman;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.SubjectResource;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpClientService;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpMethod;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpRequest;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpRequestBuilder;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpException;

public class SubjectResourceFunctionalTesting {

	@Before
	public void Before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
	}

	private void createSubject() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SubjectResource.SUBJECT)
				.body("Matemáticas:1").build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testCreateSubject() {
		this.createSubject();
	}

	@Test(expected = HttpException.class)
	public void testCreateTitleAndCourseEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SubjectResource.SUBJECT).body("")
				.build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateTitleEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SubjectResource.SUBJECT).body(":2")
				.build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateCourseEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SubjectResource.SUBJECT)
				.body("Matemáticas:").build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateWithoutResource() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testReadSubject() {
		createSubject();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(SubjectResource.SUBJECT)
				.path(SubjectResource.ID).expandPath("1").build();
		new HttpClientService().httpRequest(request);
        assertEquals("{\"id\":1,\"course\":\"1\",\"title\":\"Matemáticas\"}", new HttpClientService().httpRequest(request).getBody());
	}

	@Test(expected = HttpException.class)
	public void testReadSubjectIdNotFound() {
		createSubject();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(SubjectResource.SUBJECT)
				.path(SubjectResource.ID).expandPath("2").build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testReadSubjectWithoutId() {
		createSubject();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(SubjectResource.SUBJECT).build();
		new HttpClientService().httpRequest(request);
	}
}
