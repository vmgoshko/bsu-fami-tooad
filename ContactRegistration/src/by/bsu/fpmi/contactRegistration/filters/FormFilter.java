package by.bsu.fpmi.contactRegistration.filters;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormFilter implements Filter {

    @Override
    public boolean doFilter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastFormId = (String) request.getSession().getAttribute("lastFormId");
        int currentFormId = Integer.parseInt(request.getParameter("formId"));

        if(!lastFormId.equals("") && Integer.parseInt(lastFormId) >= currentFormId){
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return false;
        } else {
            request.getSession().setAttribute("lastFormId", String.valueOf(currentFormId));
        }

        return true;
    }
}
