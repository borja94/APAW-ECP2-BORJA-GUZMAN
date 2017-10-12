package es.upm.miw.apaw.ecp2.borja.guzman.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.StudentDao;
import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Student;

public class StudentDaoMemory extends GenericDaoMemory<Student> implements StudentDao{

	public StudentDaoMemory() {
		this.setMap(new HashMap<Integer, Student>());
	}

	@Override
	protected Integer getId(Student entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Student entity, Integer id) {
		entity.setId(id);
	}

}
