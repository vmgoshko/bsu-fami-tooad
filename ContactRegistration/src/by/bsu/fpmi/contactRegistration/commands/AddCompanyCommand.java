package by.bsu.fpmi.contactRegistration.commands;

import by.bsu.fpmi.contactRegistration.model.Person;
import java.util.Arrays;
import java.util.Map;

public class AddCompanyCommand implements Command {

    @Override
    public void execute(Map<String, Object> model, Person person) {
        String lastFormId = model.get("lastFormId").toString();
        Integer formId = Integer.parseInt(model.get("formId").toString());

        model.put("lastFormId", formId.toString());

        if (!lastFormId.equals("") && Integer.parseInt(lastFormId) < formId){
            person.setCompany(model.get("company").toString());
            model.put("page", "hobby.jsp");
        } else {
            if (person.getCompany().equals(model.get("company"))){
                model.put("page", "hobby.jsp");
            } else {
                person = new Person();
                model.put("page","index.jsp");
            }
        }
    }
}
