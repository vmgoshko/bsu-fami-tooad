package by.bsu.fpmi.contactRegistration.controller;

import by.bsu.fpmi.contactRegistration.dispatcher.Dispatcher;
import by.bsu.fpmi.contactRegistration.dispatcher.HttpDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    private Dispatcher dispatcher = new HttpDispatcher();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ((HttpDispatcher)dispatcher).dispatch(req, resp);
    }
}
