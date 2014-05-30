package by.bsu.fpmi.contactRegistration.services.sevicesImpl;

import by.bsu.fpmi.contactRegistration.dao.daoImpl.PersonDaoImpl;
import by.bsu.fpmi.contactRegistration.model.Person;
import by.bsu.fpmi.contactRegistration.services.PersonService;

public class PersonServiceImpl implements PersonService {
    PersonDaoImpl personDao;

    public PersonServiceImpl() {
        personDao = new PersonDaoImpl();
    }

    @Override
    public void save(Person person) {
        personDao.save(person);

    }
}
