package by.bsu.fpmi.contactRegistration.commands;

import by.bsu.fpmi.contactRegistration.model.Person;

import java.util.Map;

public class AddFullNameCommand implements Command {



    @Override
    public void execute(Map<String, Object> model, Person person) {
        String lastFormIdObj = model.get("lastFormId").toString();
        Integer formId = Integer.parseInt(model.get("formId").toString());

        model.put("lastFormId", formId.toString());

        if (!lastFormIdObj.equals("") && (Integer.parseInt(lastFormIdObj) < formId)){
            person = new Person();
        }

        person.setFirstName(model.get("firstname").toString());
        person.setLastName(model.get("lastname").toString());
        model.put("page", "company.jsp");
    }
}
