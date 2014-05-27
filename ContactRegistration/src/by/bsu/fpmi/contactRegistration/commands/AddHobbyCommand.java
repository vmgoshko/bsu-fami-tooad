package by.bsu.fpmi.contactRegistration.commands;

import by.bsu.fpmi.contactRegistration.model.Person;
import by.bsu.fpmi.contactRegistration.services.sevicesImpl.PersonServiceImpl;

import java.util.Map;

public class AddHobbyCommand implements Command {

    @Override
    public void execute(Map<String, Object> model) {
        Person person = (Person) model.get("person");
        person.setHobby(model.get("hobby").toString());
        model.put("page", "success");
        model.put("pageNum", "1");

        PersonServiceImpl personService = new PersonServiceImpl();
        personService.save(person);
    }
}
