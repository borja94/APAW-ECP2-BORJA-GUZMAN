package es.upm.miw.apaw.ecp2.borja.guzman.api.controllers;

import java.util.Optional;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.dtos.SubjectDto;
import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Subject;

public class SubjectController {

	public void createSubject(String title, int course) {
		Subject entity = new Subject(title, course);
		DaoFactory.getFactory().getSubjectDao().create(entity);
	}

	public Optional<SubjectDto> readSubject(int id) {
		if(existSubjectId(id)) {
			return Optional.of(new SubjectDto(DaoFactory.getFactory().getSubjectDao().read(id)));
		}
		else
		{
			return Optional.empty();
		}
	}
	 private boolean existSubjectId(int id) {
	        return DaoFactory.getFactory().getSubjectDao().read(id) != null;
	    }
}
