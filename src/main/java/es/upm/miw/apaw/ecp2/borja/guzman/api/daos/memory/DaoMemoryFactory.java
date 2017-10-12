package es.upm.miw.apaw.ecp2.borja.guzman.api.daos.memory;

import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.StudentDao;
import es.upm.miw.apaw.ecp2.borja.guzman.api.daos.SubjectDao;

public class DaoMemoryFactory extends DaoFactory {

    private SubjectDao subjectDao;
    private StudentDao studentDao;


    @Override
    public SubjectDao getSubjectDao() {
        if (subjectDao == null) {
        	subjectDao = new SubjectDaoMemory();
        }
        return subjectDao;
    }
    
    @Override
    public StudentDao getStudentDao() {
        if (studentDao == null) {
        	studentDao = new StudentDaoMemory();
        }
        return studentDao;
    }

}
