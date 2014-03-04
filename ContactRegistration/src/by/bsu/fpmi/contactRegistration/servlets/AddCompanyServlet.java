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
        Person person = (Person) request.getSession().getAttribute("person");

        personService.saveCompany(person, request.getParameter("companyname"));

        request.getRequestDispatcher("hobby.jsp").forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
