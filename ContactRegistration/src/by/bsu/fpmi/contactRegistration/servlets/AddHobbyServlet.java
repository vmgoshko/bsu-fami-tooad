package by.bsu.fpmi.contactRegistration.servlets;

import by.bsu.fpmi.contactRegistration.model.Person;
import by.bsu.fpmi.contactRegistration.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AddHobbyServlet extends HttpServlet {

    private PersonService personService = new PersonService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastFormIdObj = (String) request.getSession().getAttribute("lastFormId");

        Integer formId = Integer.parseInt(request.getParameter("formId"));

        Person person = (Person) request.getSession().getAttribute("person");
        request.getSession().setAttribute("lastFormId", formId.toString());

        if (!lastFormIdObj.equals("") && Integer.parseInt(lastFormIdObj) < formId){
            personService.saveHobby(person, request.getParameter("hobby"));
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            if (person.getHobby().equals(request.getParameter("hobby"))){
                response.sendRedirect("success.jsp");
            } else {
                request.getSession().setAttribute("person", new Person());
                response.sendRedirect("index.jsp");
            }
        }


    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

}
