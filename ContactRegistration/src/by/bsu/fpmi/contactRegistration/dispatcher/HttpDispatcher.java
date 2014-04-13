package by.bsu.fpmi.contactRegistration.dispatcher;


import by.bsu.fpmi.contactRegistration.utils.ModelBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class HttpDispatcher extends Dispatcher {

    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> model = ModelBuilder.build(request);

        super.invoke(model);

        request.getRequestDispatcher((String) model.get("page")).forward(request, response);
    }
}
