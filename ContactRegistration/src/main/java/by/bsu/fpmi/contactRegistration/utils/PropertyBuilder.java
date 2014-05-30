package by.bsu.fpmi.contactRegistration.utils;

import javax.servlet.http.HttpServletRequest;

public class PropertyBuilder {

    public static void build(HttpServletRequest request){
        Configuration configuration = new Configuration();

        configuration.setContextPath(request.getServletContext().getRealPath(""));
        configuration.setXmlStorage(request.getServletContext().getRealPath("\\WEB-INF\\classes\\by\\bsu\\fpmi\\contactRegistration\\xml\\database.xml"));
        configuration.setPageData(request.getServletContext().getRealPath("\\WEB-INF\\classes\\by\\bsu\\fpmi\\contactRegistration\\xml\\pageData.xml"));
    }
}
