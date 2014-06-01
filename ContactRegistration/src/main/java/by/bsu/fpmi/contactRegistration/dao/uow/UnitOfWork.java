package by.bsu.fpmi.contactRegistration.dao.uow;

import by.bsu.fpmi.contactRegistration.dao.PersonDao;
import by.bsu.fpmi.contactRegistration.dao.daoImpl.PersonDaoImpl;
import by.bsu.fpmi.contactRegistration.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {

    private PersonDao dao = PersonDaoImpl.getInstance();
    private static UnitOfWork instance;
    private List<Person> newObjects;
    private List<Person> updatedObjects;

    public static UnitOfWork getInstance() {
        if (instance == null) {
            instance = new UnitOfWork();
        }
        return instance;
    }

    private UnitOfWork() {
        newObjects = new ArrayList<Person>();
        updatedObjects = new ArrayList<Person>();
    }

    public void load(Person person) {
        newObjects.add(person);
    }

    public void commit() {
        for (Person person : newObjects)
            dao.save(person);
    }
}
