package by.bsu.fpmi.contactRegistration.servlets;

import by.bsu.fpmi.contactRegistration.model.Person;
import by.bsu.fpmi.contactRegistration.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AddCompanyServlet extends HttpServlet {

    private PersonService personService = new PersonService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastFormIdObj = (String) request.getSession().getAttribute("lastFormId");
        Integer formId = Integer.parseInt(request.getParameter("formId"));

        Person person;
        request.getSession().setAttribute("lastFormId", formId.toString());

        if (!lastFormIdObj.equals("") && Integer.parseInt(lastFormIdObj) < formId){
            person = (Person) request.getSession().getAttribute("person");
            personService.saveCompany(person, request.getParameter("companyname"));
            request.getRequestDispatcher("hobby.jsp").forward(request, response);
        } else {
            person = (Person) request.getSession().getAttribute("person");
            if (person.getCompany().equals(request.getParameter("companyname"))){
                response.sendRedirect("hobby.jsp");
            } else {
                person = new Person();
                request.getSession().setAttribute("person", person);
                response.sendRedirect("index.jsp");
            }

        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
