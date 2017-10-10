package es.upm.miw.apaw.ecp2.borja.guzman.api.daos.memory;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.SubjectDao;

public class DaoMemoryFactory extends DaoFactory {

    private SubjectDao subjectDao;


    @Override
    public SubjectDao getSubjectDao() {
        if (subjectDao == null) {
        	subjectDao = new SubjectDaoMemory();
        }
        return subjectDao;
    }

}
