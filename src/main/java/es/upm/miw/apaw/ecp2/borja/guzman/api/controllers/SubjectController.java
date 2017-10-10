package es.upm.miw.apaw.ecp2.borja.guzman.api.controllers;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Subject;

public class SubjectController {

	public void createSubject(String title, int course) {
		Subject entity = new Subject(title,course);
		DaoFactory.getFactory().getSubjectDao().create(entity);
	}
}
