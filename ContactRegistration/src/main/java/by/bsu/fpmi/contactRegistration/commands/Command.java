package by.bsu.fpmi.contactRegistration.commands;

import by.bsu.fpmi.contactRegistration.exception.RoleAccessException;

import java.util.Map;

public interface Command {

    void execute(Map<String, Object> model) throws RoleAccessException;
}
