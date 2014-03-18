package by.bsu.fpmi.contactRegistration.commands;

import by.bsu.fpmi.contactRegistration.model.Person;

import java.util.Map;

public interface Command {

    void execute(Map<String, Object> model, Person person);
}
