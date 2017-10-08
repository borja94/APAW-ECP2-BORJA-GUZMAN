package es.upm.miw.apaw.ecp2.borja.guzman.api;

import es.upm.miw.apaw.ecp2.borja.guzman.api.recources.SubjectResource;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpRequest;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpResponse;
import es.upm.miw.apaw.ecp2.borja.guzman.http.HttpStatus;

public class Dispatcher {

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(SubjectResource.SUBJECT)) {
			} else {
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
