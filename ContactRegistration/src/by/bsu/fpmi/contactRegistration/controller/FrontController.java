package by.bsu.fpmi.contactRegistration.controller;

import by.bsu.fpmi.contactRegistration.dispatcher.Dispatcher;
import by.bsu.fpmi.contactRegistration.dispatcher.HttpDispatcher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    private Dispatcher dispatcher = new HttpDispatcher();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ((HttpDispatcher)dispatcher).dispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
