package es.upm.miw.apaw.ecp2.borja.guzman.api.controllers;

import java.util.Calendar;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
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
}
