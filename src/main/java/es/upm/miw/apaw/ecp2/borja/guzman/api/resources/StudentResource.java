package es.upm.miw.apaw.ecp2.borja.guzman.api.resources;

import java.util.Calendar;

import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.FieldsInvalidException;

public class StudentResource {

	public static final String STUDENT = "student";

	public void createStudent(String name, String dni, Calendar birthdate, Integer idSubject) throws FieldsInvalidException {
		this.validateObligatoryFields(name, dni, birthdate);
	}

	public void validateObligatoryFields(String name, String dni, Calendar birthdate) throws FieldsInvalidException {
		if (name == null || name.isEmpty()) {
			throw new FieldsInvalidException();
		} else if (dni == null || dni.isEmpty()) {
			throw new FieldsInvalidException();
		} else if (birthdate == null) {
			throw new FieldsInvalidException();
		}
	}

}
