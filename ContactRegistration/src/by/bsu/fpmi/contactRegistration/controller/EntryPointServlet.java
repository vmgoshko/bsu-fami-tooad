package by.bsu.fpmi.contactRegistration.controller;

import by.bsu.fpmi.contactRegistration.filters.Filter;
import by.bsu.fpmi.contactRegistration.filters.FilterFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EntryPointServlet extends HttpServlet {

    private FrontController frontController = new FrontController();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Filter> filters = new FilterFactory().createFilters();
        for (Filter filter : filters) {
            if (!filter.doFilter(request, response))
                return;
        }

        frontController.service(request, response);
    }
}
