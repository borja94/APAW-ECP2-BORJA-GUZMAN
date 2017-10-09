package es.upm.miw.apaw.ecp2.borja.guzman.api.resources;

import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.FieldsInvalidException;

public class SubjectResource {

	public static final String SUBJECT = "subject";

	public void createSubject(String subject, int course) throws FieldsInvalidException {
		this.validateFileds(subject, course);
	}

	public void validateFileds(String subject, int course) throws FieldsInvalidException {
		if (subject == null || subject.isEmpty()) {
			throw new FieldsInvalidException(subject);
		}
		if (course < 1) {
			throw new FieldsInvalidException("course");
		}
	}
}
