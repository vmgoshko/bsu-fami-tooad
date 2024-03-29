package by.bsu.fpmi.contactRegistration.commands;

import by.bsu.fpmi.contactRegistration.aspect.SecurityRole;
import by.bsu.fpmi.contactRegistration.exception.RoleAccessException;
import by.bsu.fpmi.contactRegistration.model.Person;

import java.util.Map;

public class AddFullNameCommand implements Command {

    @SecurityRole
    @Override
    public void execute(Map<String, Object> model) throws RoleAccessException{
        Person person = (Person) model.get("person");

        person.setFirstName(model.get("firstname").toString());
        person.setLastName(model.get("lastname").toString());

        model.put("page", "company");
    }
}
