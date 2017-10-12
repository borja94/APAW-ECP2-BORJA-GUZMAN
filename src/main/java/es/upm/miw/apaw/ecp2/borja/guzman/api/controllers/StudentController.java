package es.upm.miw.apaw.ecp2.borja.guzman.api.controllers;

import java.util.Calendar;
import java.util.Optional;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.dtos.StudentDto;
import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Student;
import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Subject;

public class StudentController {

	public boolean createStudent(String name, String dni, Calendar birthdate, Integer idSubject) {

		Subject subject = DaoFactory.getFactory().getSubjectDao().read(idSubject);
		if (subject != null) {
			Student student = new Student(dni, name, birthdate, subject);
			DaoFactory.getFactory().getStudentDao().create(student);
			return true;
		} else {
			return false;
		}
	}

	public Optional<StudentDto> readStudent(int id) {
		if (existStudent(id)) {
			return Optional.of(new StudentDto(DaoFactory.getFactory().getStudentDao().read(id)));
		}
		return Optional.empty();
	}

	private boolean existStudent(int id) {
		return DaoFactory.getFactory().getStudentDao().read(id) != null;
	}

	public StudentDto deleteStudent(int id) {
		if (existStudent(id)) {
			StudentDto result = new StudentDto(DaoFactory.getFactory().getStudentDao().read(id));
			DaoFactory.getFactory().getStudentDao().deleteById(id);
			return result;
		} else {
			return new StudentDto();
		}

	}
}
