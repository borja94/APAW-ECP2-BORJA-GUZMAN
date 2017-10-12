package es.upm.miw.apaw.ecp2.borja.guzman.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.ecp2.borja.guzman.api.controllers.SubjectController;
import es.upm.miw.apaw.ecp2.borja.guzman.api.dtos.SubjectDto;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.FieldsInvalidException;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.SubjectIdNotFoundException;

public class SubjectResource {

	public static final String SUBJECT = "subject";
    public static final String ID = "/{id}";


    public SubjectDto readTheme(int id) throws SubjectIdNotFoundException {
    	Optional<SubjectDto> optional =  new SubjectController().readSubject(id);
    	return optional.orElseThrow(()->new SubjectIdNotFoundException(Integer.toString(id)));
    }
	public void createSubject(String subject, int course) throws FieldsInvalidException {
		this.validateFileds(subject, course);
		new SubjectController().createSubject(subject,course);
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
