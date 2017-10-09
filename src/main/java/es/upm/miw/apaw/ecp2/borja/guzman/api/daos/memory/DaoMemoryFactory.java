package es.upm.miw.apaw.ecp2.borja.guzman.api.daos.memory;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.SubjectDao;

public class DaoMemoryFactory extends DaoFactory {

    private SubjectDao themeDao;


    @Override
    public SubjectDao getSubjectDao() {
        if (themeDao == null) {
            themeDao = new SubjectDaoMemory();
        }
        return themeDao;
    }

}
