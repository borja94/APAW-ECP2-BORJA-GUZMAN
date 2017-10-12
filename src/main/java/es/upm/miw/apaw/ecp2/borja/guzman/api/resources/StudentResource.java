package es.upm.miw.apaw.ecp2.borja.guzman.api.resources;

import java.util.Calendar;
import java.util.Optional;

import es.upm.miw.apaw.ecp2.borja.guzman.api.controllers.StudentController;
import es.upm.miw.apaw.ecp2.borja.guzman.api.dtos.StudentDto;
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

	public StudentDto readStudent(int id) throws StudentIdNotFoundException {
		
		Optional<StudentDto> optional = new StudentController().readStudent(id);
		return optional.orElseThrow(() -> new StudentIdNotFoundException(Integer.toString(id)));
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
