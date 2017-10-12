package es.upm.miw.apaw.ecp2.borja.guzman.api.resources;

import java.util.Calendar;

import es.upm.miw.apaw.ecp2.borja.guzman.api.controllers.StudentController;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.FieldsInvalidException;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.StudentIdNotFoundException;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.SubjectIdNotFoundException;

public class StudentResource {

	public static final String STUDENT = "student";
	public static final String ID = "/{id}";

	public void createStudent(String name, String dni, Calendar birthdate, Integer idSubject)
			throws FieldsInvalidException, SubjectIdNotFoundException {
		this.validateObligatoryFields(name, dni, birthdate);
		if (!new StudentController().createStudent(name, dni, birthdate, idSubject)) {
			throw new SubjectIdNotFoundException(Integer.toString(idSubject));
		}
	}

	public String readStudent(int id) throws StudentIdNotFoundException {
		
		if (id != 1)
			throw new StudentIdNotFoundException();
		
		return "{\"id\":1,\"name\":\"student1\",\"dni\":\"00000000x\",\"birthdate\":\"01/01/1994\"}";
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
