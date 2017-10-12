package es.upm.miw.apaw.ecp2.borja.guzman.api;

import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpRequest;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpResponse;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpStatus;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.RequestInvalidException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.StudentResource;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.SubjectResource;;

public class Dispatcher {

	private SubjectResource subjectResource = new SubjectResource();
	private StudentResource studentResource = new StudentResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(SubjectResource.SUBJECT + SubjectResource.ID)) {
				response.setBody(subjectResource.readTheme(Integer.valueOf(request.paths()[1])).toString());

			} else {
				throw new RequestInvalidException(request.getPath());
			}
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(SubjectResource.SUBJECT)) {

				String title = request.getBody().split(":")[0]; // body="themeId:vote"
				String course = request.getBody().split(":")[1];
				subjectResource.createSubject(title, Integer.valueOf(course));

			} else if (request.isEqualsPath(StudentResource.STUDENT)) {

				String name = request.getBody().split(":")[0];
				String dni = request.getBody().split(":")[1];
				String birthdateAux = request.getBody().split(":")[2];
				String subjectId = request.getBody().split(":")[3];

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				cal.setTime(sdf.parse(birthdateAux));
				studentResource.createStudent(name, dni, cal, Integer.valueOf(subjectId));

			} else {
				throw new RequestInvalidException(request.getPath());
			}
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
	}

	public void doPatch(HttpRequest request, HttpResponse response) {
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
	}

}
