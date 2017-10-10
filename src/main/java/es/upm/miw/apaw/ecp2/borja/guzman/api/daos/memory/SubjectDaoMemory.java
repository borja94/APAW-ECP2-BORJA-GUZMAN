package es.upm.miw.apaw.ecp2.borja.guzman.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.SubjectDao;
import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Subject;

public class SubjectDaoMemory extends GenericDaoMemory<Subject> implements SubjectDao {

	public SubjectDaoMemory() {
		this.setMap(new HashMap<Integer, Subject>());
	}

	@Override
	protected Integer getId(Subject entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Subject entity, Integer id) {
		entity.setId(id);

	}

}
