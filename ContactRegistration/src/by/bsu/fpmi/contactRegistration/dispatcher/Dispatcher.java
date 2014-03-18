package by.bsu.fpmi.contactRegistration.dispatcher;

import by.bsu.fpmi.contactRegistration.commands.AddCompanyCommand;
import by.bsu.fpmi.contactRegistration.commands.AddFullNameCommand;
import by.bsu.fpmi.contactRegistration.commands.AddHobbyCommand;
import by.bsu.fpmi.contactRegistration.commands.Command;
import by.bsu.fpmi.contactRegistration.model.Person;

import java.util.Map;

public class Dispatcher {

    public void invoke(Map<String, Object> model, Person person){
        factory(model).execute(model, person);
    }

    private Command factory(Map<String, Object> model){
        if (model.get("action").equals("addFullName")){
            return new AddFullNameCommand();
        } else if(model.get("action").equals("addCompany")){
            return new AddCompanyCommand();
        } else if(model.get("action").equals("addHobby")){
            return new AddHobbyCommand();
        }
     return null;
    }
}
