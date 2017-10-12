package es.upm.miw.apaw.ecp2.borja.guzman.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.dtos.StudentDto;
import es.upm.miw.apaw.ecp2.borja.guzman.api.dtos.StudentsBySubjectDto;
import es.upm.miw.apaw.ecp2.borja.guzman.api.dtos.SubjectDto;
import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Student;
import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Subject;

public class SubjectController {

	public void createSubject(String title, int course) {
		Subject entity = new Subject(title, course);
		DaoFactory.getFactory().getSubjectDao().create(entity);
	}

	public Optional<SubjectDto> readSubject(int id) {
		if (existSubjectId(id)) {
			return Optional.of(new SubjectDto(DaoFactory.getFactory().getSubjectDao().read(id)));
		} else {
			return Optional.empty();
		}
	}

	public Boolean isRepeated(String title, int course) {
		Boolean result = false;
		List<Subject> subjects = DaoFactory.getFactory().getSubjectDao().findAll();
		for (Subject item : subjects) {
			if (item.getTitle().toUpperCase().equals(title.toUpperCase()) && item.getCourse() == course) {
				result = true;
				break;
			}
		}
		return result;
	}

	private boolean existSubjectId(int id) {
		return DaoFactory.getFactory().getSubjectDao().read(id) != null;
	}

	public Optional<StudentsBySubjectDto> readStudentsBySubject(int id) {
		if (existSubjectId(id)) {
			SubjectDto subject = new SubjectDto(DaoFactory.getFactory().getSubjectDao().read(id));
			List<Student> studentsAux = DaoFactory.getFactory().getStudentDao().findAll();
			List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
			for (Student item : studentsAux) {
				if (item.getSubject().getId() == subject.getId()) {
					studentDtoList.add(new StudentDto(item));
				}
			}
			return Optional.of(new StudentsBySubjectDto(studentDtoList, subject));
		} else {
			return Optional.empty();
		}
	}
}
