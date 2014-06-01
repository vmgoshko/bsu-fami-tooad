package by.bsu.fpmi.contactRegistration.dispatcher;

import by.bsu.fpmi.contactRegistration.commands.Command;
import by.bsu.fpmi.contactRegistration.exception.RoleAccessException;
import by.bsu.fpmi.contactRegistration.utils.Configuration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Map;

public class Dispatcher {
    private static final String ADD_FULL_NAME_ACTION = "addFullName";
    private static final String ADD_COMPANY_ACTION = "addCompanyName";
    private static final String ADD_HOBBY_ACTION = "addHobbyName";
    ConfigurableApplicationContext context;

    public void invoke(Map<String, Object> model) throws RoleAccessException {
        context = new FileSystemXmlApplicationContext(Configuration.contextPath + "\\WEB-INF\\application-context.xml");
        factory(model).execute(model);
    }

    private Command factory(Map<String, Object> model) {
        String action = (String) model.get("action");
        switch (action) {
            case ADD_FULL_NAME_ACTION:
                return (Command) context.getBean("fullNameCommand");
            case ADD_COMPANY_ACTION:
                return (Command) context.getBean("companyCommand");
            case ADD_HOBBY_ACTION:
                return (Command) context.getBean("hobbyCommand");
            default:
                throw new NullPointerException("Action does not exist");
        }

    }
}
