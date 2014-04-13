package by.bsu.fpmi.contactRegistration.commands;

import by.bsu.fpmi.contactRegistration.model.Person;

import java.util.Map;

public class AddCompanyCommand implements Command {

    @Override
    public void execute(Map<String, Object> model) {
        Person person = (Person) model.get("person");
        person.setCompany(model.get("company").toString());
        model.put("page", "hobby");
    }
}
