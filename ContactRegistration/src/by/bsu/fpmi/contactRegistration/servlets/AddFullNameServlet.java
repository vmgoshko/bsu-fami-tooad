package by.bsu.fpmi.contactRegistration.servlets;

import by.bsu.fpmi.contactRegistration.model.Person;
import by.bsu.fpmi.contactRegistration.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AddFullNameServlet extends HttpServlet {

    private PersonService personService = new PersonService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastFormIdObj = (String) request.getSession().getAttribute("lastFormId");
        Integer formId = Integer.parseInt(request.getParameter("formId"));

        Person person;
        request.getSession().setAttribute("lastFormId", formId.toString());

        if (!lastFormIdObj.equals("") && Integer.parseInt(lastFormIdObj) < formId){
            person = (Person) request.getSession().getAttribute("person");
        } else {
            person = new Person();
            request.getSession().setAttribute("person", person);
        }

        personService.saveFullName(person,
                request.getParameter("firstname"),
                request.getParameter("lastname"));

        request.getRequestDispatcher("company.jsp").forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    }
}
