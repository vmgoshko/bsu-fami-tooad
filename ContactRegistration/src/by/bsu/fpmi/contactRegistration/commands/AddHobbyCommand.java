package by.bsu.fpmi.contactRegistration.commands;

import by.bsu.fpmi.contactRegistration.model.Person;

import java.util.Map;

public class AddHobbyCommand implements Command {

    @Override
    public void execute(Map<String, Object> model) {
        Person person =(Person)model.get("person");
        String lastFormIdObj = model.get("lastFormId").toString();
        Integer formId = Integer.parseInt(model.get("formId").toString());

        model.put("lastFormId", formId.toString());

        if (!lastFormIdObj.equals("") && Integer.parseInt(lastFormIdObj) < formId){
            person.setHobby(model.get("hobby").toString());
            model.put("page", "success.jsp");
        } else {
            if (person.getHobby().equals(model.get("hobby").toString())){
                model.put("page", "success.jsp");
            } else {
                person =  new Person();
                model.put("page", "index.jsp");
            }
        }

    }
}
