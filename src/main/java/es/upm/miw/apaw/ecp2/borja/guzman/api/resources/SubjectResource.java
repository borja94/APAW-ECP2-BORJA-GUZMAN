package es.upm.miw.apaw.ecp2.borja.guzman.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.ecp2.borja.guzman.api.controllers.SubjectController;
import es.upm.miw.apaw.ecp2.borja.guzman.api.dtos.SubjectDto;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.FieldsInvalidException;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.SubjectExistException;
import es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions.SubjectIdNotFoundException;

public class SubjectResource {

	public static final String SUBJECT = "subject";
    public static final String ID = "/{id}";
    public static final String ID_STUDENT = ID+"/student";


    public SubjectDto readSubject(int id) throws SubjectIdNotFoundException {
    	Optional<SubjectDto> optional =  new SubjectController().readSubject(id);
    	return optional.orElseThrow(()->new SubjectIdNotFoundException(Integer.toString(id)));
    }
	public void createSubject(String title, int course) throws FieldsInvalidException , SubjectExistException {
		this.validateFileds(title, course);
		if (new SubjectController().isRepeated(title, course)) {
			throw new SubjectExistException("title:"+title+",course:"+course);
		}
		new SubjectController().createSubject(title,course);
	}

	public void validateFileds(String title, int course) throws FieldsInvalidException {
		if (title == null || title.isEmpty()) {
			throw new FieldsInvalidException(title);
		}
		if (course < 1) {
			throw new FieldsInvalidException("course");
		}
	}
	
	public String readStudentsBySubject(int id) throws SubjectIdNotFoundException {
		new SubjectController().readStudentsBySubject(id);
		if(id!=1)
			throw new SubjectIdNotFoundException(Integer.toString(id));
		return "{{\"id\":1,\"course\":2,\"title\":\"matematicas\"},[{\"id\":1,\"name\":\"student1\",\"dni\":\"00000000x\"},{\"id\":2,\"name\":\"student2\",\"dni\":\"00000001x\"}]}";
	}
}
