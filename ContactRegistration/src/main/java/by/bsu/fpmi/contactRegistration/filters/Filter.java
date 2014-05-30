package by.bsu.fpmi.contactRegistration.filters;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Filter {

    public boolean doFilter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
